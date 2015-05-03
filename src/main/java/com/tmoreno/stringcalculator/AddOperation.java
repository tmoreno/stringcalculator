package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class AddOperation {

	public int add(List<Integer> numbers) {
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
