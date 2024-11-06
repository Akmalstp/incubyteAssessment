package com.akmal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	public void testSimpleStringCalculator() {
		StringCalculator stringCal = new StringCalculator();
		String inputStr = "2,3,4,3,5";
		Assertions.assertEquals(17, stringCal.add(inputStr));
	}
}
