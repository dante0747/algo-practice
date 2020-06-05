package dev.coderator.algopractice.datastructure.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

	@Test
	void exists() {
		BinarySearchTree binarySearchTree = binarySearchTree();
		assertEquals(true, binarySearchTree.exists(8));
		assertEquals(false, binarySearchTree.exists(0));
		assertEquals(true, binarySearchTree.exists(10));
		assertEquals(false, binarySearchTree.exists(-1));
	}

	@Test
	void preOrderTraversalArray() {
		assertEquals("[7, 4, 1, 6, 9, 8, 10]", Arrays.toString(binarySearchTree().preOrderTraversalArray()));
	}

	@Test
	void inOrderTraversalArray() {
		assertEquals("[1, 4, 6, 7, 8, 9, 10]", Arrays.toString(binarySearchTree().inOrderTraversalArray()));
	}

	@Test
	void postOrderTraversalArray() {
		assertEquals("[1, 6, 4, 8, 10, 9, 7]", Arrays.toString(binarySearchTree().postOrderTraversalArray()));
	}

	@Test
	void height() {
		BinarySearchTree binarySearchTree = binarySearchTree();
		assertEquals(2, binarySearchTree.height());

		binarySearchTree.insert(20);
		assertEquals(3, binarySearchTree.height());

		binarySearchTree.insert(0);
		assertEquals(3, binarySearchTree.height());

		binarySearchTree.insert(13);
		assertEquals(4, binarySearchTree.height());

		binarySearchTree.insert(12);
		assertEquals(5, binarySearchTree.height());

		binarySearchTree.insert(14);
		assertEquals(5, binarySearchTree.height());
	}

	@Test
	void minValue(){
		BinarySearchTree binarySearchTree = binarySearchTree();
		assertEquals(1, binarySearchTree.min());

		binarySearchTree.insert(20);
		assertEquals(1, binarySearchTree.min());

		binarySearchTree.insert(-100);
		assertEquals(-100, binarySearchTree.min());
	}

	private BinarySearchTree binarySearchTree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree(7);
		binarySearchTree.insert(4);
		binarySearchTree.insert(9);
		binarySearchTree.insert(1);
		binarySearchTree.insert(6);
		binarySearchTree.insert(8);
		binarySearchTree.insert(10);

		return binarySearchTree;
	}
}