package com.text.calculator.validation;

import java.util.List;
import java.util.Set;

import com.text.calculator.util.Helper;

public class Validator {

	/**
	 * This method can be used to check if the given expression is valid or not
	 * @param expression
	 * @return
	 */
	public static boolean isMathematicalExpressionValid(String expression) {
		List<String> tokens = Helper.getTokens(expression);

		if (null == tokens || tokens.size() == 0) {
			return false;
		}

		final Set<String> textOperators = Helper.getSetOfAcceptableOperators();
		final Set<String> textNumbers = Helper.getSetOfAcceptableNumbers();

		return isExpressionStartAndEndWithNumberToken(tokens, textNumbers)
				&& isExpressionContainsValidNumberOfTokens(tokens)
				&& !isExpressionContainsInvalidToken(tokens, textOperators, textNumbers);

	}

	private static boolean isExpressionContainsInvalidToken(List<String> tokens, Set<String> textOperators,
			Set<String> textNumbers) {
		return tokens.stream().anyMatch(
				token -> (!textOperators.contains(token.toLowerCase()) && !textNumbers.contains(token.toLowerCase())));
	}

	private static boolean isExpressionContainsValidNumberOfTokens(List<String> tokens) {
		return (null != tokens && tokens.size() % 2 != 0);
	}

	private static boolean isExpressionStartAndEndWithNumberToken(
			List<String> tokens, Set<String> textNumbers) {
		
		return textNumbers.contains(tokens.get(0)) 
				&& textNumbers.contains(tokens.get(tokens.size() - 1));
	}

}
