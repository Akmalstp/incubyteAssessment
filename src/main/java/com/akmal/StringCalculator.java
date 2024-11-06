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
		    scanner.useDelimiter(",");
		    while (scanner.hasNext()) {
		        numberSum = numberSum.add(new BigInteger(scanner.next()));
		    }
		    scanner.close();
		    System.out.println("Sum is : " + numberSum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberSum;
	}

}
