package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	private Parser parser;
	
	public StringCalculator(Parser parser){
		this.parser = parser;
	}

	public int add(String input) {
		parser.newInput(input);
		
		if (parser.getInput().isEmpty()) {
			return 0;
		}
		
		List<Integer> numbers = parser.getNumbers();
				
		int result = 0;
		List<Integer> negatives = new ArrayList<>();
		for (Integer number : numbers) {
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