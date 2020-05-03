package dev.coderator.algopractice.exercise._5;

import java.util.Stack;

public class StackifyQueue {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public StackifyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void enqueue(int item) {
		stack1.push(item);
	}

	public int dequeue() {
		if (isEmpty())
			throw new IllegalStateException();

		transfer();
		return stack2.pop();
	}

	public int peek() {
		transfer();
		return stack2.peek();
	}

	private void transfer() {
		if (stack2.isEmpty())
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public Integer[] toArray() {
		return stack1.toArray(new Integer[stack1.size()]);
	}
}
