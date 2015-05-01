package com.tmoreno.stringcalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	
	private StringCalculator calculator;
	private int result;
	
	@Before
	public void setUp() {
		calculator = new StringCalculator();
	}
    
	@Test
	public void addWithEmptyStringReturnZero(){
		result = calculator.add("");
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void addWithOneNumberReturnThatNumber(){
		result = calculator.add("1");
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void addTwoNumbersReturnTheSum(){
		result = calculator.add("1,2");
		Assert.assertEquals(3, result);
	}

	@Test
	public void addMultipleNumbers(){
		result = calculator.add("1,2,3,4");
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void allowNewLineAsDelimiter(){
		result = calculator.add("1\n2");
		Assert.assertEquals(3, result);
	}
}