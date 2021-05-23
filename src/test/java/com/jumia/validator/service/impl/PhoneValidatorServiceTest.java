package com.jumia.validator.service.impl;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.jumia.validator.dto.ValidationRequestDTO;
import com.jumia.validator.dto.ValidationResponseDTO;
import com.jumia.validator.entity.CustomerEntitiy;
import com.jumia.validator.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PhoneValidatorServiceTest {

	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	PhoneValidatorServiceImpl service;
	
	@Before
	public void executedBeforeTest() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(service, "pageSize", 10);
		
		List<CustomerEntitiy> customers = new ArrayList<>();
		customers.add(new CustomerEntitiy(1, "Ahmed", "011000000000"));
		Page<CustomerEntitiy> allEntitesPerPage = new PageImpl(customers); 
		Mockito.when(customerRepository.findAll(Matchers.isA(Pageable.class))).thenReturn(allEntitesPerPage);
		Mockito.lenient().when(customerRepository.findByPhoneStartsWith(Mockito.anyString(), Matchers.isA(Pageable.class))).thenReturn(customers);
	}
	
	@Test
	public void validatePhoneNumbers_ValidCountryName() {
		ValidationRequestDTO request = new ValidationRequestDTO("Morocco", 1);
		
		ResponseEntity<ValidationResponseDTO> response = service.validatePhoneNumbers(request);
		
		assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
	}
	
	@Test
	public void validatePhoneNumbers_AllCountries() {
		ValidationRequestDTO request = new ValidationRequestDTO("all", 1);
		
		ResponseEntity<ValidationResponseDTO> response = service.validatePhoneNumbers(request);
		
		assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
	}
	
	@Test
	public void validatePhoneNumbers_WrongCountryName() {
		ValidationRequestDTO request = new ValidationRequestDTO("Egypt", 1);
		
		ResponseEntity<ValidationResponseDTO> response = service.validatePhoneNumbers(request);
		
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode().value());
	}
}
