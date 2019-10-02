package com.text.calculator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.text.calculator.model.BinaryOperator;
import com.text.calculator.model.SupportedNumber;

public class HelperTest {

	@Test
	public void testGetTokens() {
		String userInput = "one     plus      two";
		List<String> tokens = Helper.getTokens(userInput);

		assertNotNull(tokens);
		assertFalse(tokens.isEmpty());
		assertEquals(3, tokens.size());
	}

	@Test
	public void testGetTokens_Empty() {
		String userInput = "            ";
		List<String> tokens = Helper.getTokens(userInput);

		assertNotNull(tokens);
		assertTrue(tokens.isEmpty());
		assertEquals(0, tokens.size());
	}

	@Test
	public void testGetOperator_Plus() {
		String textOperator = "plus";
		BinaryOperator operator = Helper.getOperator(textOperator);

		assertNotNull(operator);
		assertEquals(BinaryOperator.ADD, operator);
	}

	@Test
	public void testGetOperator_Mul() {
		String textOperator = "multiplied-by";
		BinaryOperator operator = Helper.getOperator(textOperator);

		assertNotNull(operator);
		assertEquals(BinaryOperator.MULTIPLY, operator);
		assertEquals(2, operator.getPrecedence());
	}

	@Test
	public void testGetNumber_One() {
		String numberText = "one";
		SupportedNumber number = Helper.getNumber(numberText);

		assertNotNull(number);
		assertEquals(SupportedNumber.ONE, number);
		assertEquals(1, number.getNumber());
	}

	@Test
	public void testIsNumber_five() {

		SupportedNumber five = Helper.getNumber("five");

		assertNotNull(five);
		assertEquals(SupportedNumber.FIVE, five);
		assertEquals(5, five.getNumber());
	}

	@Test
	public void testIsNumber_invalid() {

		boolean isNum = Helper.isNumber("dummy");
		assertFalse(isNum);
	}

}
