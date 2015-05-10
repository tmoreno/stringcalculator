package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

	public void validate(List<Integer> numbers) {
		List<Integer> negatives = new ArrayList<>();
		
		for (Integer number : numbers) {
			if (number < 0) {
				negatives.add(number);
			}
		}
		
		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + negatives.toString());
		}
	}
}