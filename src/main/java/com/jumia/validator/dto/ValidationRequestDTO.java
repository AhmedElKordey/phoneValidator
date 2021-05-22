package com.jumia.validator.dto;

import java.io.Serializable;

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
public class ValidationRequestDTO implements Serializable {
	private static final long serialVersionUID = -6406279554777569110L;
	private String country;
	private int pageNumber;
}
