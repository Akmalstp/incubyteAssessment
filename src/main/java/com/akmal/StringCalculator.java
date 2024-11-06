package com.akmal;

import org.springframework.stereotype.Component;

@Component
public class StringCalculator {

	public int add(String numbers) {
		int numberSum = 0;
		String[] numberArrayStr = numbers.split(",");
		for (String numStr : numberArrayStr) {
			numberSum += Integer.parseInt(numStr);
		}
		System.out.println("Sum is : " + numberSum);
		return numberSum;
	}
}
