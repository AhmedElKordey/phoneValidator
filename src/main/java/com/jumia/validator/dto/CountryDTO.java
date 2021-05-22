package com.jumia.validator.dto;

import java.util.List;
import java.util.regex.Pattern;

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
public class CountryDTO {
	private String name;
	private String code;
	private List<Pattern> validationPattern;
	
	public String getDisplayedCode() {
		return new StringBuilder().append("+").append(this.code).toString() ;
	}
	
	public String getQueryCode() {
		return new StringBuilder().append("(").append(this.code).append(")").toString() ;
	}
}
