package com.tmoreno.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	private static final String BEGIN_LINE_DELIMITER = "//";
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
		
		if (newInput.startsWith(BEGIN_LINE_DELIMITER)) {
			delimiter = newInput.charAt(BEGIN_LINE_DELIMITER.length()) + "";
			input = newInput.substring(BEGIN_LINE_DELIMITER.length() + delimiter.length() + 1);
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
