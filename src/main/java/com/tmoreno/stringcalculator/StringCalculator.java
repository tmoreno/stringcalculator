package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String input) {
		Parser parser = Parser.createFromInput(input);
		
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