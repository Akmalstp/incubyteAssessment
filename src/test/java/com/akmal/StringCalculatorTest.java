package com.akmal;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	public void testSimpleStringCalculator() {
		StringCalculator stringCal = new StringCalculator();
		String inputStr = "2,3,4,3,5";
		Assertions.assertEquals(17, stringCal.add(inputStr).intValueExact());
	}

	@Test
	public void testWithLargeNumbers() {
		StringCalculator stringCal = new StringCalculator();
		StringBuilder inputStringBuff = new StringBuilder();
		// already reaching limit for int
		inputStringBuff.append("2147483647000,");
		for (int i = 0; i < 1000; i++) {
			inputStringBuff.append(100000 * i).append(",");
		}
		inputStringBuff.deleteCharAt(inputStringBuff.length() - 1);
		Assertions.assertEquals(true,
				BigInteger.valueOf(2197433647000L).equals(stringCal.add(inputStringBuff.toString())));
	}
}
