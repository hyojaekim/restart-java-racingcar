package com.hyojae.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

	public static void main(String[] args) throws IOException {
		String inputData = input();
		CalculatorRunner runner = new CalculatorRunner(inputData);

		double result = runner.calculate();
		print(result);
	}

	private static String input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}

	private static void print(double result) {
		System.out.println(result);
	}
}
