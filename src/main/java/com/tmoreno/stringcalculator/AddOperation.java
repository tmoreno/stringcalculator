package com.tmoreno.stringcalculator;

import java.util.List;

public class AddOperation {

	public int add(List<Integer> numbers) {
		int result = 0;
		
		for (Integer number : numbers) {
			result += number;
		}
		
		return result;
	}
}
