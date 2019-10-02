package com.text.calculator.model;

public enum SupportedNumber {

	ZERO(0, "zero"), 
	ONE(1, "one"), 
	TWO(2, "two"), 
	THREE(3, "three"), 
	FOUR(4, "four"), 
	FIVE(5, "five"),
	SIX(6, "six"), 
	SEVEN(7, "seven"), 
	EIGHT(8, "eight"), 
	NINE(9, "nine"), 
	TEN(10, "ten");

	private final String textNumber;
	private final int number;

	SupportedNumber(int number, String textNumber) {
		this.textNumber = textNumber;
		this.number = number;
	}

	public String getTextNumber() {
		return textNumber;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return this.textNumber + ": " + this.number;
	}
}
