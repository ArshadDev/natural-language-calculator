package com.text.calculator.impl;

import java.text.DecimalFormat;

import com.text.calculator.exception.InvalidMethameticalExpression;
import com.text.calculator.model.BinaryOperator;
import com.text.calculator.model.CustomStack;
import com.text.calculator.util.Helper;
import com.text.calculator.validation.Validator;

public class TextBasedCalculator {

	/**
	 * This method can be used to evaluate text based Mathematical expression
	 * 
	 * @param inputExpression
	 * @return
	 */
	public static String evaluateMathematicalExpression(final String inputExpression) {
		
		String finalResult = null;

		if (Validator.isMathematicalExpressionValid(inputExpression)) {

			final CustomStack<Double> numberStack = new CustomStack<>();
			final CustomStack<BinaryOperator> operatorStack = new CustomStack<>();
			finalResult = calculateResult(inputExpression, numberStack, operatorStack);

		} else {
			throw new InvalidMethameticalExpression(inputExpression);
		}
		return finalResult;
	}

	private static String calculateResult(final String inputExpression, final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operatorStack) {

		for (String token : Helper.getTokens(inputExpression)) {
			addTokenToStack(numberStack, operatorStack, token);
		}
		applyRemainingOperators(numberStack, operatorStack);
		return getFinalResult(inputExpression, numberStack, operatorStack);
	}

	private static void addTokenToStack(final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operatorStack, final String token) {

		if (Helper.isNumber(token)) {
			addNumberToStack(numberStack, token);
		} else {
			addOperatorToStack(numberStack, operatorStack, token);
		}
	}

	private static void addNumberToStack(final CustomStack<Double> numberStack, final String token) {
		numberStack.push(Double.parseDouble(String.valueOf(Helper.getNumber(token).getNumber())));
	}

	private static void addOperatorToStack(final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operatorStack, final String token) {

		final BinaryOperator operator = Helper.getOperator(token);

		if (operatorStack.isEmpty() || operator.getPrecedence() > operatorStack.top().getPrecedence()) {
			operatorStack.push(operator);
		} else {
			while (!operatorStack.isEmpty() && operator.getPrecedence() <= operatorStack.top().getPrecedence()) {
				applyRecentOperator(numberStack, operatorStack);
			}
			operatorStack.push(operator);
		}
	}

	private static void applyRemainingOperators(final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operatorStack) {

		while (!operatorStack.isEmpty()) {
			applyRecentOperator(numberStack, operatorStack);
		}
	}

	private static void applyRecentOperator(final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operatorStack) {

		final BinaryOperator operatorToApply = operatorStack.top();
		operatorStack.pop();
		performOperation(operatorToApply, numberStack, operatorStack);
	}

	private static void performOperation(final BinaryOperator operatorToApply, final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operators) {

		final Double rhsNumber = getTopElementFromStack(numberStack);
		final Double lhsNumber = getTopElementFromStack(numberStack);
		final Double result = operatorToApply.apply(lhsNumber, rhsNumber);
		numberStack.push(result);
	}

	private static <T> T getTopElementFromStack(final CustomStack<T> stack) {

		T element;
		if (stack.isEmpty()) {
			throw new InvalidMethameticalExpression();
		} else {
			element = stack.top();
			stack.pop();
		}
		return element;
	}

	private static String getFinalResult(final String expression, final CustomStack<Double> numberStack,
			final CustomStack<BinaryOperator> operatorStack) {

		Double result = numberStack.top();
		numberStack.pop();
		
		if (!operatorStack.isEmpty() || !numberStack.isEmpty()) {
			throw new InvalidMethameticalExpression(expression);
		}
		
		return getFormattedResult(result);
	}

	private static String getFormattedResult(final Double result) {

		final DecimalFormat df = new DecimalFormat("0.##");
		return df.format(result);
	}

}
