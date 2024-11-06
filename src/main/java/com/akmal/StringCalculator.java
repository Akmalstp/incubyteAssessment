package com.akmal;

import org.springframework.stereotype.Component;

@Component
public class StringCalculator {

	public int add(String numbers) {
		int numberSum = 0;
		try {
			String[] numberArrayStr = numbers.split(",");
			for (String numStr : numberArrayStr) {
				numberSum += Integer.parseInt(numStr);
			}
			System.out.println("Sum is : " + numberSum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberSum;
	}
}
