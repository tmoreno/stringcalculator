package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	private static final String DEFAULT_DEMILITER = ",";

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String delimiter = DEFAULT_DEMILITER;
		if (input.startsWith("//")) {
			delimiter = input.charAt(2) + "";
			input = input.substring(4);
		}
		
		if (input.indexOf("\n" + delimiter) > 0) {
			throw new IllegalArgumentException();
		}
		
		List<String> numbers = new ArrayList<>(); 

		String inputWhitoutCommas[] = input.split(delimiter);
		for (String item : inputWhitoutCommas) {
			numbers.addAll(Arrays.asList(item.split("\n")));
		}
		
		int result = 0;
		int number;
		List<Integer> negatives = new ArrayList<>();
		for (String stringNumber : numbers) {
			number = Integer.parseInt(stringNumber);
			
			if (number < 0) {
				negatives.add(number);
			}
			else {
				result += number;
			}
		}
		
		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + negatives.toString());
		}
		
		return result;
	}

}