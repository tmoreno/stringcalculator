package com.tmoreno.stringcalculator;

public class StringCalculator {

	public int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		
		String numbers[] = input.split(",");
		
		if (numbers.length > 1) {
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			
			return a + b;
		}
		else {
			return Integer.parseInt(numbers[0]);
		}
	}

}