package com.hyojae.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorUtils {

	private static final String NUMBER_EXTRACTION_REGEX = "[+\\-*/]";
	private static final String OPERATOR_EXTRACTION_REGEX = "[0-9]";
	private static final int FIRST_INDEX = 0;

	private CalculatorUtils() {
	}

	public static List<Integer> extractNumbers(String inputData) {
		List<Integer> result = new ArrayList<>();
		for (String number : inputData.split(NUMBER_EXTRACTION_REGEX)) {
			int convertedNumber = convertNumber(number);
			result.add(convertedNumber);
		}
		return result;
	}

	private static int convertNumber(String number) {
		number = number.trim();
		return Integer.parseInt(number);
	}

	public static List<Character> extractOperators(String inputData) {
		List<Character> result = new ArrayList<>();
		String[] split = inputData.split(OPERATOR_EXTRACTION_REGEX);
		for (String operator : split) {
			add(result, operator);
		}
		return result;
	}

	private static void add(List<Character> result, String operator) {
		operator = operator.trim();
		if (!operator.isEmpty()) {
			result.add(operator.charAt(FIRST_INDEX));
		}
	}
}
