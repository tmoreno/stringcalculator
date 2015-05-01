package com.tmoreno.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    
	@Test
	public void addWithEmptyStringReturnZero(){
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("");
		Assert.assertEquals(0, result);
	}

}