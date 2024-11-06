package com.akmal;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class StringCalculator {

	public BigInteger add(String numbers) {
		BigInteger numberSum = BigInteger.ZERO;
		try {
			String delimiter = "[,\n]";
			if (numbers.startsWith("//")) {
				int delimiterEndIndex = numbers.indexOf("\n");
				if (delimiterEndIndex != -1) {
					delimiter = numbers.substring(2, delimiterEndIndex).trim();
					numbers = numbers.substring(delimiterEndIndex + 1);
				}
			}
			Scanner scanner = new Scanner(new StringReader(numbers));
			scanner.useDelimiter(Pattern.compile(delimiter));
			while (scanner.hasNext()) {
				String num = scanner.next().trim();
				if (!num.isEmpty()) {
					//removing new line and extra spaces.
					numberSum = numberSum.add(new BigInteger(num.replaceAll("\\s+", "")));
				}
			}
			scanner.close();
			System.out.println("Sum is : " + numberSum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberSum;
	}
}
