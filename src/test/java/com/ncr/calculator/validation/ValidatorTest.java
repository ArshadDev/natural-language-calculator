package com.text.calculator.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void testIsMathematicalExpressionValid_valid() {

		String expression = "one    plus   five";
		boolean isValid = Validator.isMathematicalExpressionValid(expression);
		assertTrue(isValid);
	}

	@Test
	public void testIsMathematicalExpressionValid_InValid_1() {

		String expression = "one    plus   five  over";
		boolean isValid = Validator.isMathematicalExpressionValid(expression);
		assertFalse(isValid);
	}

	@Test
	public void testIsMathematicalExpressionValid_InValid_2() {

		String expression = "one    plus   five  over seven six";
		boolean isValid = Validator.isMathematicalExpressionValid(expression);
		assertFalse(isValid);
	}

	@Test
	public void testIsMathematicalExpressionValid_InValid_3() {

		String expression = "one    test   five";
		boolean isValid = Validator.isMathematicalExpressionValid(expression);
		assertFalse(isValid);
	}

}
