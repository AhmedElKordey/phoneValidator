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
public class CustomerDTO implements Serializable{
	private static final long serialVersionUID = 6301392628336058774L;
	private int id;
	private String name;
	private String phone;
	private boolean validNumber;
}
