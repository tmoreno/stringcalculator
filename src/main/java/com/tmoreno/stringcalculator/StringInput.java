package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringInput {

	private static final String DEFAULT_DEMILITER = ",";

	private String delimiter;
	private String input;
	
	public StringInput(){
		delimiter = DEFAULT_DEMILITER;
		input = "";
	}
	
	public static StringInput createFromInput(String input){
		StringInput stringInput = new StringInput();
		
		stringInput.setDelimiter(DEFAULT_DEMILITER);
		stringInput.setInput(input);
		
		if (input.startsWith("//")) {
			stringInput.setDelimiter(input.charAt(2) + "");
			stringInput.setInput(input.substring(4));
		}
		
		if (stringInput.getInput().indexOf("\n" + stringInput.getDelimiter()) > 0) {
			throw new IllegalArgumentException();
		}
		
		return stringInput;
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

	public String getDelimiter() {
		return delimiter;
	}

	private void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String getInput() {
		return input;
	}

	private void setInput(String input) {
		this.input = input;
	}
}
