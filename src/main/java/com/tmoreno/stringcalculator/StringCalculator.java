package com.tmoreno.stringcalculator;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String numbers[] = input.split(",");
		
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		
		return result;
	}

}