package com.jumia.validator.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.validator.dto.ValidationRequestDTO;
import com.jumia.validator.dto.ValidationResponseDTO;
import com.jumia.validator.service.PhoneValidatorService;

@RestController
@RequestMapping("api/phones/validation")
@Validated
public class PhoneValidatorController {

	@Autowired
	PhoneValidatorService phoneValidator;

	@GetMapping("info")
	@ResponseBody
	public ResponseEntity<ValidationResponseDTO> info() {
		ValidationResponseDTO response = new ValidationResponseDTO();
		response.setStatusMsg("Service is Up and Running");
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<ValidationResponseDTO> result(
			@RequestParam(defaultValue = "all") @Pattern(regexp = "[A-Za-z ]*", message = "Country name not vaild") String country,
			@RequestParam(defaultValue = "1") @Min(1) int pageNumber) {
		ValidationRequestDTO request = new ValidationRequestDTO(country, pageNumber);
		return phoneValidator.validatePhoneNumbers(request);
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity<ValidationResponseDTO> handleException() {
		ValidationResponseDTO response = new ValidationResponseDTO();
		response.setStatusMsg("Service is not avaliable now");
		return ResponseEntity.ok(response);
	}
}
