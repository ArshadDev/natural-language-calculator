package com.text.calculator.model;

import java.util.ArrayList;

public class CustomStack<T> {

	private ArrayList<T> elements;

	public CustomStack() {
		elements = new ArrayList<T>();
	}

	public boolean isEmpty() {
		return elements.size() == 0;
	}

	public T top() {
		return elements.get(elements.size() - 1);
	}

	public void push(T t) {
		elements.add(t);
	}

	public void pop() {
		elements.remove(elements.size() - 1);
	}

}
