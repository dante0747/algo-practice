package dev.coderator.algopractice.exercise._3;

import java.util.Objects;

public class LinkedList {

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;

	public LinkedList(int... items) {
		for (int item : items)
			addNode(item);
	}

	private void addNode(int item) {
		Node node = new Node(item);

		if (isEmpty())
			first = last = node;
		else {
			last.next = node;
			last = node;
		}
	}

	private boolean isEmpty() {
		return Objects.isNull(first);
	}

	public int kthFromTheEnd(int k) {

		if (isEmpty())
			throw new IllegalStateException("the linked list is empty!");

		if (k < 1)
			throw new IllegalArgumentException();

		int counter = 0;
		Node current = first;
		Node target = first;
		while (Objects.nonNull(current)) {
			if (counter++ >= k)
				target = target.next;
			current = current.next;
		}

		if (counter < k)
			throw new IllegalArgumentException();

		return target.value;
	}
}

