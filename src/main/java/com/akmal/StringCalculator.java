package com.akmal;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class StringCalculator {

	public BigInteger add(String numbers) {
		BigInteger numberSum = BigInteger.ZERO;
		try {
			Scanner scanner = new Scanner(new StringReader(numbers));
			scanner.useDelimiter("[,\n]");
			while (scanner.hasNext()) {
				String num = scanner.next().trim();
				if (!num.isEmpty()) {
					numberSum = numberSum.add(new BigInteger(num));
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
