package dev.coderator.algopractice.exercise._8;

import java.util.Objects;

public class BinarySearchTree {
	private class Node {
		private int value;
		private Node rightChild;
		private Node leftChild;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	private Node root;

	public BinarySearchTree(int... items) {
		root = new Node(items[0]);
		for (var item : items)
			insert(item);
	}

	private void insert(int value) {
		var current = root;
		var node = new Node(value);

		while (true) {
			if (value == current.value)
				break;

			if (value > current.value) {
				if (Objects.isNull(current.rightChild)) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			} else {
				if (Objects.isNull(current.leftChild)) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			}
		}
	}

	public boolean equals(BinarySearchTree other) {
		return equals(root, other.root);
	}

	private boolean equals(Node first, Node second) {

		if (Objects.isNull(first) && Objects.isNull(second))
			return true;

		if (Objects.nonNull(first) && Objects.nonNull(second))
			return first.value == second.value &&
					equals(first.rightChild, second.rightChild) &&
					equals(first.leftChild, second.leftChild);

		return false;
	}
}
