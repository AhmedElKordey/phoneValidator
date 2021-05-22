package com.jumia.validator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jumia.validator.dto.CountryDTO;
import com.jumia.validator.dto.CustomerDTO;
import com.jumia.validator.dto.ValidationRequestDTO;
import com.jumia.validator.dto.ValidationResponseDTO;
import com.jumia.validator.entity.CustomerEntitiy;
import com.jumia.validator.repository.CustomerRepository;
import com.jumia.validator.service.PhoneValidatorService;
import com.jumia.validator.utils.CountryFactory;

@Service
public class PhoneValidatorServiceImpl implements PhoneValidatorService {

	@Autowired
	CustomerRepository customerRepository;

	@Value("${page.size}")
	private Integer pageSize;

	@Override
	public ResponseEntity<ValidationResponseDTO> validatePhoneNumbers(ValidationRequestDTO request) {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		List<CustomerEntitiy> customerEntitys = new ArrayList<>();
		Pageable requestedPage = PageRequest.of(request.getPageNumber() - 1, pageSize);
		CountryDTO country = CountryFactory.getCountry(request.getCountry());
		try {
			if (country == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

			if (country.getCode().equalsIgnoreCase("000")) {
				Page<CustomerEntitiy> allEntitesPerPage = customerRepository.findAll(requestedPage);
				customerEntitys = allEntitesPerPage.hasContent() ? allEntitesPerPage.getContent() : new ArrayList<>();
			} else {
				customerEntitys = customerRepository.findByPhoneStartsWith(country.getQueryCode(), requestedPage);
			}
			customerDTOs = convertCustomerEntityToDTO(customerEntitys);
			validate(customerDTOs, country.getValidationPattern());
			return prepareResonse(customerDTOs, country, null, true);
		} catch (Exception e) {
			return prepareResonse(customerDTOs, country, e.getMessage(), false);
		}
	}

	private List<CustomerDTO> convertCustomerEntityToDTO(List<CustomerEntitiy> customerEntitys) {
		return customerEntitys.stream()
				.map(entity -> new CustomerDTO(entity.getId(), entity.getName(), entity.getPhone(), false))
				.collect(Collectors.toList());
	}

	private void validate(List<CustomerDTO> customerDTOs, List<Pattern> patterns) {
		customerDTOs.stream().forEach(customer -> {
			String customerPhone = customer.getPhone();
			boolean validNumber = patterns.stream().anyMatch(pattern -> pattern.matcher(customerPhone).matches());
			customer.setValidNumber(validNumber);
		});
	}

	/**
	 * in case we want to display it as map of valid and unvalid numbers in each
	 * page but i prefer 1st solution
	 */
	private Map<Boolean, List<CustomerDTO>> validateToMap(List<CustomerDTO> customerDTOs, List<Pattern> patterns) {
		return customerDTOs.stream().collect(Collectors.partitioningBy(
				customer -> patterns.stream().anyMatch(pattern -> pattern.matcher(customer.getPhone()).matches())));

	}

	private ResponseEntity<ValidationResponseDTO> prepareResonse(List<CustomerDTO> customerDTOs, CountryDTO country,
			String msg, boolean done) {
		ValidationResponseDTO response = new ValidationResponseDTO(customerDTOs, country.getName(),
				country.getDisplayedCode(), msg);
		return done ? ResponseEntity.ok(response)
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
