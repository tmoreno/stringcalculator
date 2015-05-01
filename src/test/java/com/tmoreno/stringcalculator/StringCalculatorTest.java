package com.tmoreno.stringcalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
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
	
	@Test
	public void combineDelimiters(){
		result = calculator.add("1\n2,3");
		Assert.assertEquals(6, result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void twoDelimitersTogetherNotAllowed(){
		calculator.add("1,\n3");
	}
	
	@Test
	public void supportDifferentDelimiters(){
		result = calculator.add("//;\n1;2");
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void negativeNumbersIsNotAllowed(){
		expectedEx.expect(IllegalArgumentException.class); 
		expectedEx.expectMessage("negatives not allowed: -1");
		
		calculator.add("-1");
	}
}