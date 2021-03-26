package com.hyojae.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorUtils {

	private static final String OPERATOR_REGEX = "[+\\-*/]";

	private CalculatorUtils() {
	}

	public static List<Integer> extractNumbers(String inputData) {
		List<Integer> result = new ArrayList<>();
		for (String number : inputData.split(OPERATOR_REGEX)) {
			int convertedNumber = convertNumber(number);
			result.add(convertedNumber);
		}
		return result;
	}

	private static int convertNumber(String number) {
		number = number.trim();
		return Integer.parseInt(number);
	}
}
