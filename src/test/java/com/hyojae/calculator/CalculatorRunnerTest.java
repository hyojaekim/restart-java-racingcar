package com.hyojae.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorRunnerTest {

	@Test
	void 문자열을_숫자와_연산자를_추출하여_계산한다() {
		String inputData = "2 + 3 * 4 / 2";
		CalculatorRunner runner = new CalculatorRunner(inputData);

		double result = runner.calculate();

		assertThat(result).isEqualTo(10);
	}
}