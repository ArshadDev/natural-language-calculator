package com.text.calculator.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.text.calculator.exception.InvalidMethameticalExpression;

public class TextBasedCalculatorTest {

	@Test
	public void testevaluateMathematicalExpression_1() {

		String result = TextBasedCalculator.evaluateMathematicalExpression("one   plus   five");
		assertNotNull(result);
		assertEquals("6", result);
	}

	@Test
	public void testevaluateMathematicalExpression_2() {

		String result = TextBasedCalculator
				.evaluateMathematicalExpression("nine over eight plus four times two divided-by three");
		assertNotNull(result);
		assertEquals("3.79", result);
	}

	@Test
	public void testevaluateMathematicalExpression_3() {

		String result = TextBasedCalculator.evaluateMathematicalExpression("one plus six");
		assertNotNull(result);
		assertEquals("7", result);
	}

	@Test
	public void testevaluateMathematicalExpression_4() {

		String result = TextBasedCalculator.evaluateMathematicalExpression("one plus two times three");
		assertNotNull(result);
		assertEquals("7", result);
	}

	@Test
	public void testevaluateMathematicalExpression_5() {

		String result = TextBasedCalculator.evaluateMathematicalExpression("nine minus three times seven");
		assertNotNull(result);
		assertEquals("-12", result);
	}

	@Test
	public void testevaluateMathematicalExpression_6() {

		String result = TextBasedCalculator.evaluateMathematicalExpression("four minus eight plus six times nine");
		assertNotNull(result);
		assertEquals("50", result);
	}

	@Test
	public void testevaluateMathematicalExpression_7() {

		String result = TextBasedCalculator.evaluateMathematicalExpression("seven over nine plus two");
		assertNotNull(result);
		assertEquals("2.78", result);
	}

	@Test(expected = InvalidMethameticalExpression.class)
	public void testevaluateMathematicalExpression_InValid_1() {
		TextBasedCalculator.evaluateMathematicalExpression("seven test two");
	}
	
	@Test(expected = InvalidMethameticalExpression.class)
	public void testevaluateMathematicalExpression_InValid_2() {
		TextBasedCalculator.evaluateMathematicalExpression(null);
	}
	
	@Test(expected = InvalidMethameticalExpression.class)
	public void testevaluateMathematicalExpression_InValid_3() {
		TextBasedCalculator.evaluateMathematicalExpression("                     ");
	}
}
