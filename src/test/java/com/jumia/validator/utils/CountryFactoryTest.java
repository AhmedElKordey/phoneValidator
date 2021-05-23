package com.jumia.validator.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.jumia.validator.dto.CountryDTO;

public class CountryFactoryTest {

	@Test
	public void getCountry_cameroon() {
		CountryDTO result =  CountryFactory.getCountry("Cameroon");
		assertEquals("237", result.getCode());
	}
	
	@Test
	public void getCountry_ethiopia() {
		CountryDTO result =  CountryFactory.getCountry("Ethiopia");
		assertEquals("251", result.getCode());
	}
	
	@Test
	public void getCountry_morocco() {
		CountryDTO result =  CountryFactory.getCountry("Morocco");
		assertEquals("212", result.getCode());
	}
	
	@Test
	public void getCountry_mozambique() {
		CountryDTO result =  CountryFactory.getCountry("Mozambique");
		assertEquals("258", result.getCode());
	}
	
	@Test
	public void getCountry_uganda() {
		CountryDTO result =  CountryFactory.getCountry("Uganda");
		assertEquals("256", result.getCode());
	}
	
	@Test
	public void getCountry_all() {
		CountryDTO result =  CountryFactory.getCountry("all");
		assertEquals("000", result.getCode());
	}
	
	@Test
	public void getCountry_notInList() {
		CountryDTO result =  CountryFactory.getCountry("Egypt");
		assertNull(result);
	}
}
