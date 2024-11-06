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

	@Test
	public void testWithNewLineAsDelimiter() {
		StringCalculator stringCal = new StringCalculator();
		StringBuilder inputStringBuff = new StringBuilder();

		inputStringBuff.append("2147483647000\n");
		BigInteger expectedSum = BigInteger.valueOf(2147483647000L);
		for (int i = 0; i < 1000; i++) {
			inputStringBuff.append(100000 * i).append("\n");
			expectedSum = expectedSum.add(BigInteger.valueOf(100000L * i));
		}
		if (inputStringBuff.charAt(inputStringBuff.length() - 1) == '\n') {
			inputStringBuff.deleteCharAt(inputStringBuff.length() - 1);
		}
		Assertions.assertEquals(expectedSum, stringCal.add(inputStringBuff.toString()));
	}

	@Test
	public void testWithDelimeterAtNewLine() {
		StringCalculator stringCal = new StringCalculator();
		StringBuilder inputStringBuff = new StringBuilder();

		inputStringBuff.append("//;\n");
		inputStringBuff.append("2147483647000").append("\n");
		BigInteger expectedSum = BigInteger.valueOf(21474836470000L);
		for (int i = 0; i < 1000; i++) {
			inputStringBuff.append(100000 * i).append(";");
			expectedSum = expectedSum.add(BigInteger.valueOf(100000L * i));
		}
		if (inputStringBuff.charAt(inputStringBuff.length() - 1) == ';') {
			inputStringBuff.deleteCharAt(inputStringBuff.length() - 1);
		}
		Assertions.assertEquals(expectedSum, stringCal.add(inputStringBuff.toString()));
	}
}
