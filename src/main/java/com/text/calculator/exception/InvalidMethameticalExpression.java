package com.text.calculator.exception;

public class InvalidMethameticalExpression extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMethameticalExpression(final String errorMessage) {
		super("User entered Invalid Methametical Expression : " + errorMessage);
	}

	public InvalidMethameticalExpression() {
		super("User entered Invalid Methametical Expression !!");
	}

}
