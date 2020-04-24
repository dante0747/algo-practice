package dev.coderator.algopractice.datastructure;

import java.util.Arrays;

public class Stack {

	private int top = -1;
	private int[] items;

	public Stack() {
		items = new int[5];
	}

	public void push(int item) {
		if (items.length == top + 1)
			throw new StackOverflowError();

		items[++top] = item;
	}

	public int pop() {
		if (top == -1)
			throw new IllegalStateException("stack is empty!");

		return items[top--];
	}

	public int peek() {
		return items[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(items, 0, top + 1));
	}
}
