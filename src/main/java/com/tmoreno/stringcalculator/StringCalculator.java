package com.tmoreno.stringcalculator;

import java.util.List;

public class StringCalculator {
	
	private Parser parser;
	private AddOperation addOperation;
	
	public StringCalculator(Parser parser, AddOperation addOperation){
		this.parser = parser;
		this.addOperation = addOperation;
	}

	public int add(String input) {
		parser.newInput(input);
		
		if (parser.getInput().isEmpty()) {
			return 0;
		}
		
		List<Integer> numbers = parser.getNumbers();
		
		return addOperation.add(numbers);
	}
}