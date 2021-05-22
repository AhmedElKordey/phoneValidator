package com.jumia.validator.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidationResponseDTO implements Serializable {
	private static final long serialVersionUID = -3550331968680012312L;
	private List<CustomerDTO> response;
	private String countryName;
	private String countryCode;
	private String statusMsg;
}
