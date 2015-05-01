package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		if (input.indexOf("\n,") > 0) {
			throw new IllegalArgumentException();
		}
		
		List<String> numbers = new ArrayList<>(); 

		String inputWhitoutCommas[] = input.split(",");
		for (String item : inputWhitoutCommas) {
			numbers.addAll(Arrays.asList(item.split("\n")));
		}
		
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		
		return result;
	}

}