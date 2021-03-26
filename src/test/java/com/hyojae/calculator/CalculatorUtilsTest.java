package com.hyojae.calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorUtilsTest {

	@Test
	void 숫자를_추출한다() {
		List<Integer> numbers = CalculatorUtils.extractNumbers("10 / 2 + 3 + 132");

		assertThat(numbers.size()).isEqualTo(4);
		assertThat(numbers).isEqualTo(Arrays.asList(10, 2, 3, 132));
	}

	@Test
	void 연산자들을_추출한다() {
		List<Character> operators = CalculatorUtils.extractOperators("10 / 2 + 3 + 132");

		assertThat(operators.size()).isEqualTo(3);
		assertThat(operators).isEqualTo(Arrays.asList('/', '+', '+'));
	}
}