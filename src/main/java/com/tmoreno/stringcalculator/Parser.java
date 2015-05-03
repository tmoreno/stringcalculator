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
	
	public static Parser createFromInput(String input){
		Parser parser = new Parser();
		
		parser.setDelimiter(DEFAULT_DEMILITER);
		parser.setInput(input);
		
		if (input.startsWith("//")) {
			parser.setDelimiter(input.charAt(2) + "");
			parser.setInput(input.substring(4));
		}
		
		if (parser.getInput().indexOf("\n" + parser.getDelimiter()) > 0) {
			throw new IllegalArgumentException();
		}
		
		return parser;
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
