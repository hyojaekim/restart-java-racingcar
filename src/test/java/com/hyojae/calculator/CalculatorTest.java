package com.hyojae.calculator;

import com.hyojae.calculator.exception.InvalidOperatorException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

	@Test
	void 두_숫자를_더한다() {
		double result = Calculator.calculate(1, '+', 1);

		assertThat(result).isEqualTo(2);
	}

	@Test
	void 두_숫자를_뺀다() {
		double result = Calculator.calculate(1, '-', 1);

		assertThat(result).isEqualTo(0);
	}

	@Test
	void 두_숫자를_곱한다() {
		double result = Calculator.calculate(1, '*', 2);

		assertThat(result).isEqualTo(2);
	}

	@Test
	void 두_숫자를_나눈다() {
		double result = Calculator.calculate(1, '/', 1);

		assertThat(result).isEqualTo(1);
	}

	@Test
	void 숫자_0으로_나누는_경우_예외가_발생한다() {
		assertThrows(ArithmeticException.class,
						() -> Calculator.calculate(1, '/', 0));
	}

	@Test
	void 유효하지_않은_연산자인_경우_예외가_발생한다() {
		assertThrows(InvalidOperatorException.class,
						() -> Calculator.calculate(1, 'a', 1));
	}
}