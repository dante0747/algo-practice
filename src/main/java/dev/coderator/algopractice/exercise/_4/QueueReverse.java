package dev.coderator.algopractice.exercise._4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverse {

	private Queue<Integer> queue;

	public QueueReverse(int... items) {
		queue = new LinkedList<>();
		for (int item : items)
			queue.add(item);
	}

	public void reverse() {
		Stack<Integer> stack = new Stack();
		while (!queue.isEmpty())
			stack.push(queue.remove());

		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

	/**
	 * Note that this method is not necessary for the solution. We just put it here in order to use in the unit test.
	 *
	 * @return Integer[]
	 */
	public Integer[] toArray() {
		return queue.toArray(new Integer[queue.size()]);
	}
}
