package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String input) {
		StringInput stringInput = StringInput.createFromInput(input);
		
		if (stringInput.getInput().isEmpty()) {
			return 0;
		}
		
		List<Integer> numbers = stringInput.getNumbers();
				
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