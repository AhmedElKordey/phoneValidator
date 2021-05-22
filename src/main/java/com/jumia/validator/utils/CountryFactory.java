package com.jumia.validator.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.jumia.validator.dto.CountryDTO;

public class CountryFactory {

	private CountryFactory() {
	}

	public static CountryDTO getCountry(String country) {
		CountryDTO countryDTO;
		;
		switch (country.trim().toLowerCase()) {
		case "cameroon":
			countryDTO = new CountryDTO("Cameroon", "237",
					Arrays.asList(Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$")));
			break;
		case "ethiopia":
			countryDTO = new CountryDTO("Ethiopia", "251",
					Arrays.asList(Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$")));
			break;
		case "morocco":
			countryDTO = new CountryDTO("Morocco", "212", Arrays.asList(Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$")));
			break;
		case "mozambique":
			countryDTO = new CountryDTO("Mozambique", "258",
					Arrays.asList(Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$")));
			break;
		case "uganda":
			countryDTO = new CountryDTO("Uganda", "256", Arrays.asList(Pattern.compile("\\(256\\)\\ ?\\d{9}$")));
			break;
		case "all":
			countryDTO = new CountryDTO("All Avaliable Countries", "000",
					Arrays.asList(Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$"),
							Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$"), Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$"),
							Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$"), Pattern.compile("\\(256\\)\\ ?\\d{9}$")));
			break;
		default:
			countryDTO = null;
			break;
		}
		return countryDTO;
	}
}
