package com.text.calculator.model;

import java.util.Arrays;
import java.util.List;

public enum BinaryOperator {

	ADD(1, "add", "plus") {
		@Override
		public Double apply(final Double firstOperand, final Double secondOperand) {
			return firstOperand.doubleValue() + secondOperand.doubleValue();
		}
	},

	SUBTRACT(1, "subtract", "minus", "less") {
		@Override
		public Double apply(final Double firstOperand, final Double secondOperand) {
			return firstOperand.doubleValue() - secondOperand.doubleValue();
		}
	},

	MULTIPLY(2, "multiplied-by", "times") {
		@Override
		public Double apply(final Double firstOperand, final Double secondOperand) {
			return firstOperand.doubleValue() * secondOperand.doubleValue();
		}
	},

	DIVIDE(2, "divided-by", "over") {
		@Override
		public Double apply(final Double firstOperand, final Double secondOperand) {

			if (null == secondOperand || secondOperand.equals(new Double("0"))) {
				throw new UnsupportedOperationException("Division by 0 error");
			}
			return firstOperand.doubleValue() / secondOperand.doubleValue();
		}
	};

	private final List<String> values;
	private final int precedence;

	private BinaryOperator(int priority, String... values) {
		this.values = Arrays.asList(values);
		this.precedence = priority;
	}

	public List<String> getValues() {
		return values;
	}

	public int getPrecedence() {
		return this.precedence;
	}

	public abstract Double apply(Double firstOperand, Double secondOperand);

	@Override
	public String toString() {
		return String.join(",", values);
	}
}
