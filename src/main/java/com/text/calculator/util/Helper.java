package com.text.calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.text.calculator.exception.InvalidMethameticalExpression;
import com.text.calculator.model.BinaryOperator;
import com.text.calculator.model.SupportedNumber;

public class Helper {

	/**
	 * This method can be used to get List of tokens extracted from given expression
	 * 
	 * @param expression
	 * @return
	 */
	public static List<String> getTokens(String expression) {

		List<String> tokens = new ArrayList<>();
		if (null != expression && expression.trim().length() > 0) {
			tokens = Arrays.stream(expression.split(" "))
					.filter(str -> str.trim().length() > 0)
					.collect(Collectors.toList());
		}
		return tokens;
	}

	/**
	 * This method can be used to get the corresponding BinaryOperator for the given
	 * operator token
	 * 
	 * @param operatorText
	 * @return
	 */
	public static BinaryOperator getOperator(String operatorText) {
		return Arrays.stream(BinaryOperator.values())
				.filter(operator -> operator.getValues().contains(operatorText))
				.findFirst().orElse(null);
	}

	/**
	 * This method can be used to get the corresponding SupportedNumber for the
	 * given number token
	 * 
	 * @param numberText
	 * @return
	 */
	public static SupportedNumber getNumber(String numberText) {
		return Arrays.stream(SupportedNumber.values())
				.filter(number -> number.getTextNumber().equalsIgnoreCase(numberText))
				.findFirst().orElse(null);
	}

	/**
	 * This method can be used to check if the given token is valid/acceptable
	 * number
	 * 
	 * @param token
	 * @return
	 */
	public static boolean isNumber(String token) {
		return (null != getNumber(token));
	}

	/**
	 * This method will return set of valid/acceptable Numbers
	 * 
	 * @return
	 */
	public static Set<String> getSetOfAcceptableNumbers() {
		return Arrays.stream(SupportedNumber.values())
				.map(number -> number.getTextNumber())
				.collect(Collectors.toSet());
	}

	/**
	 * This method will return set of valid/acceptable operators
	 * 
	 * @return
	 */
	public static Set<String> getSetOfAcceptableOperators() {
		return Arrays.stream(BinaryOperator.values())
				.map(operator -> operator.getValues()).flatMap(List::stream)
				.collect(Collectors.toSet());
	}

	/**
	 * This method can be used to get the user input from console
	 * 
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String getUserInputFromConsole() {

		System.out.println("Please enter a Mathematical Expression for evaluation using valid Number and Operator\n");
		System.out.print("Input : ");

		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		if(null == expression || expression.trim().length() == 0 ) {
			throw new InvalidMethameticalExpression("Entered empty String");
		}
		return expression.toLowerCase();
	}

}
