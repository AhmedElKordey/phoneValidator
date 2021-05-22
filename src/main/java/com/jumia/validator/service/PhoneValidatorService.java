package com.jumia.validator.service;

import org.springframework.http.ResponseEntity;

import com.jumia.validator.dto.ValidationRequestDTO;
import com.jumia.validator.dto.ValidationResponseDTO;

public interface PhoneValidatorService {
	public ResponseEntity<ValidationResponseDTO> validatePhoneNumbers(ValidationRequestDTO request);
}
