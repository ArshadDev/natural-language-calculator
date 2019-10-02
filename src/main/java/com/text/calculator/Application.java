package com.text.calculator;

import com.text.calculator.impl.TextBasedCalculator;
import com.text.calculator.util.Helper;

public class Application {

	public static void main(String[] args) {

		String inputExpression = Helper.getUserInputFromConsole();
		String result = TextBasedCalculator.evaluateMathematicalExpression(inputExpression);
		System.out.println("------------------------------------------------");
		System.out.println("------------>> Final Result : " + result);
		System.out.println("------------------------------------------------");
	}
}
