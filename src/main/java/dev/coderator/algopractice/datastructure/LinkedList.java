package dev.coderator.algopractice.datastructure;

import java.util.NoSuchElementException;
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
	private int size;

	public void addFirst(int item) {
		var node = new Node(item);

		if (isEmpty())
			first = last = node;
		else {
			node.next = first;
			first = node;
		}

		size++;
	}

	public void addLast(int item) {
		var node = new Node(item);

		if (isEmpty())
			first = last = node;
		else {
			last.next = node;
			last = node;
		}

		size++;
	}

	private boolean isEmpty() {
		return Objects.isNull(first);
	}

	public int indexOf(int item) {
		var index = 0;
		var current = first;

		while (Objects.nonNull(current)) {
			if (current.value == item)
				return index;
			current = current.next;
			index++;
		}

		throw new NoSuchElementException(String.format("item not found: %d", item));
	}

	public boolean contains(int item) {
		var current = first;

		while (Objects.nonNull(current)) {
			if (current.value == item)
				return true;
			current = current.next;
		}

		return false;
	}

	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("the linked list is empty!");

		if (hasOneItem())
			first = last = null;
		else {
			var tmpNode = first;
			first = first.next;
			tmpNode.next = null;
		}

		size--;
	}

	public void removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("the linked list is empty!");

		if (hasOneItem())
			first = last = null;
		else {
			var previous = previous(last);
			last = previous;
			last.next = null;
		}

		size--;
	}

	private boolean hasOneItem() {
		return first == last && !isEmpty();
	}

	private Node previous(Node node) {
		Node previous = null;
		var current = first;

		while (current != node) {
			previous = current;
			current = current.next;
		}
		return previous;
	}

	public int size() {
		return size;
	}

	public int[] toArray() {
		var array = new int[size];

		var index = 0;
		var current = first;

		while (current != null) {
			array[index++] = current.value;
			current = current.next;
		}

		return array;
	}

	public void reverse() {
		if (isEmpty() || hasOneItem())
			return;

		var previous = first;
		var current = first.next;
		var next = current.next;

		while (Objects.nonNull(next)) {
			current.next = previous;
			previous = current;
			current = next;
			next = next.next;
		}

		last = first;
		first = current;
		first.next = previous;
		last.next = null;
	}
}

