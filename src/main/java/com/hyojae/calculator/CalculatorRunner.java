package com.hyojae.calculator;

import java.util.List;

public class CalculatorRunner {

	List<Integer> numbers;
	List<Character> operators;

	public CalculatorRunner(String inputData) {
		this.numbers = CalculatorUtils.extractNumbers(inputData);
		this.operators = CalculatorUtils.extractOperators(inputData);
	}

	public double calculate() {
		double result = numbers.get(0);

		for (int i = 0; i < operators.size(); i++) {
			char operator = operators.get(i);
			int nextNumber = numbers.get(i + 1);
			result = Calculator.calculate(result, operator, nextNumber);
		}
		return result;
	}
}
