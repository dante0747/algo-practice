package dev.coderator.algopractice.datastructure;

import java.util.LinkedList;
import java.util.Objects;

public class Tree {
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

	private int size;
	private Node root;

	public Tree(int value) {
		this.root = new Node(value);
	}

	public void insert(int value) {
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

		size++;
	}

	public boolean exists(int value) {
		var current = root;
		while (Objects.nonNull(current)) {
			if (value > current.value)
				current = current.rightChild;
			else if (value < current.value)
				current = current.leftChild;
			else
				return true;
		}
		return false;
	}

	public Integer[] preOrderTraversalArray() {
		var list = new LinkedList<Integer>();
		traversePreOrder(root, list);
		return list.toArray(new Integer[size]);
	}

	private void traversePreOrder(Node node, LinkedList<Integer> list) {
		if (Objects.isNull(node))
			return;

		list.add(node.value);
		traversePreOrder(node.leftChild, list);
		traversePreOrder(node.rightChild, list);
	}

	public Integer[] inOrderTraversalArray() {
		var list = new LinkedList<Integer>();
		traverseInOrder(root, list);
		return list.toArray(new Integer[size]);
	}

	private void traverseInOrder(Node node, LinkedList<Integer> list) {
		if (Objects.isNull(node))
			return;

		traverseInOrder(node.leftChild, list);
		list.add(node.value);
		traverseInOrder(node.rightChild, list);
	}

	public Integer[] postOrderTraversalArray() {
		var list = new LinkedList<Integer>();
		traversePostOrder(root, list);
		return list.toArray(new Integer[size]);
	}

	private void traversePostOrder(Node node, LinkedList<Integer> list) {
		if (Objects.isNull(node))
			return;

		traversePostOrder(node.leftChild, list);
		traversePostOrder(node.rightChild, list);
		list.add(node.value);
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (Objects.isNull(node))
			return Integer.MIN_VALUE;

		if (isLeaf(node))
			return 0;

		return 1 + Math.max(height(node.leftChild), height(node.rightChild));
	}

	private boolean isLeaf(Node node) {
		return Objects.isNull(node.leftChild) && Objects.isNull(node.rightChild);
	}

	// O(log(n))

	/**
	 * This method finds the minimum value in a binary search tree.
	 * Note that we can't this algorithm in a simple binary tree because only in a BST the left most node is always the
	 * smallest one.
	 *
	 * Time complexity: O(log n)
	 * @return
	 */
	public int min() {
		var current = root;
		while (current.leftChild != null)
			current = current.leftChild;

		return current.value;
	}

	/**
	 * This method finds the minimum value in a binary tree and is an alternative for the previous one.
	 *
	 * Time complexity: O(n)
	 * @return
	 */
	private int min(Node node) {
		if (Objects.isNull(node))
			return Integer.MAX_VALUE;

		if (isLeaf(node))
			return node.value;

		return Math.min(
				Math.min(min(node.leftChild), min(node.rightChild)),
				node.value
		);
	}
}
