package com.hyojae.calculator.exception;

public class InvalidOperatorException extends RuntimeException {

	public InvalidOperatorException() {
		super("올바르지 않은 연산자 입니다.");
	}
}
