package com.hyojae.calculator;

import com.hyojae.calculator.exception.InvalidOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {

	PLUS('+', (o1, o2) -> o1 + o2),
	MINUS('-', (o1, o2) -> o1 - o2),
	MULTIPLICATION('*', (o1, o2) -> o1 * o2),
	DIVISION('/', (o1, o2) -> o1 / o2);

	private final char type;
	private final BiFunction<Double, Integer, Double> calculation;

	Calculator(char type, BiFunction<Double, Integer, Double> calculation) {
		this.type = type;
		this.calculation = calculation;
	}

	public static double calculate(final double firstNumber, final char type, final int secondNumber) {
		return checkInfinity(Arrays.stream(values())
						.filter(o -> o.type == type)
						.findFirst()
						.map(o -> o.calculation.apply(firstNumber, secondNumber))
						.orElseThrow(InvalidOperatorException::new));
	}

	private static double checkInfinity(double result) {
		if (result == Double.POSITIVE_INFINITY) {
			throw new ArithmeticException();
		}
		return result;
	}
}
