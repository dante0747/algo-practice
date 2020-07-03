package dev.coderator.algopractice.exercise._9;

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

	/**
	 * This method is provided to get used in the unit tests. Note that it's a bad practice to change the code to
	 * for the sake of unit tests. However, in this exercise we just focus on the algorithm of the BST validation.
	 */
	public void swapRoot() {
		var tmp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = tmp;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {

		if (Objects.isNull(root))
			return true;

		if (root.value < min || root.value > max)
			return false;

		return isBinarySearchTree(root.leftChild, min, root.value - 1)
				&& isBinarySearchTree(root.rightChild, root.value + 1, max);
	}
}
