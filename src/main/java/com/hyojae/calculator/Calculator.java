package com.hyojae.calculator;

import com.hyojae.calculator.exception.InvalidOperatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Calculator {

	PLUS((o1, o2) -> o1 + o2),
	MINUS((o1, o2) -> o1 - o2),
	MULTIPLICATION((o1, o2) -> o1 * o2),
	DIVISION((o1, o2) -> o1 / o2);

	private static final Map<Character, Calculator> calculator;
	static {
		calculator = new HashMap<>();
		calculator.put('+', PLUS);
		calculator.put('-', MINUS);
		calculator.put('*', MULTIPLICATION);
		calculator.put('/', DIVISION);
	}

	private final BiFunction<Double, Integer, Double> calculation;

	Calculator(BiFunction<Double, Integer, Double> calculation) {
		this.calculation = calculation;
	}

	public static double calculate(final double firstNumber, final char operator, final int secondNumber) {
		double result = Optional.ofNullable(calculator.get(operator))
						.map(c -> c.calculation.apply(firstNumber, secondNumber))
						.orElseThrow(InvalidOperatorException::new);

		return checkInfinity(result);
	}

	private static double checkInfinity(double result) {
		if (result == Double.POSITIVE_INFINITY) {
			throw new ArithmeticException();
		}
		return result;
	}
}
