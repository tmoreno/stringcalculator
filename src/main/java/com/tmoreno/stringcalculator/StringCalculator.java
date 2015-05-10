package com.tmoreno.stringcalculator;

import java.util.List;

public class StringCalculator {
	
	private Parser parser;
	private Validator validator;
	private AddOperation addOperation;
	
	public StringCalculator(Parser parser, Validator validator, AddOperation addOperation){
		this.parser = parser;
		this.validator = validator;
		this.addOperation = addOperation;
	}

	public int add(String input) {
		parser.newInput(input);
		
		if (parser.getInput().isEmpty()) {
			return 0;
		}
		
		List<Integer> numbers = parser.getNumbers();
		
		validator.validate(numbers);
		
		return addOperation.add(numbers);
	}
}