package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	private static final String DEFAULT_DEMILITER = ",";

	private String delimiter;
	private String input;
	
	public Parser(){
		delimiter = DEFAULT_DEMILITER;
		input = "";
	}
	
	public void newInput(String newInput){
		delimiter = DEFAULT_DEMILITER;
		input = newInput;
		
		if (newInput.startsWith("//")) {
			delimiter = newInput.charAt(2) + "";
			input = newInput.substring(4);
		}
		
		if (input.indexOf("\n" + delimiter) > 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public List<Integer> getNumbers(){
		List<Integer> numbers = new ArrayList<>(); 

		String inputWhitoutDelimiter[] = input.split(delimiter);
		
		String stringNumbers [];
		for (String item : inputWhitoutDelimiter) {
			stringNumbers = item.split("\n");
			
			for (String stringNumber : stringNumbers) {
				numbers.add(Integer.parseInt(stringNumber));
			}
		}
		
		return numbers;
	}

	public String getInput() {
		return input;
	}
}
