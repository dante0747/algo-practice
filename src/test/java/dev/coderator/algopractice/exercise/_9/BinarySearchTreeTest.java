package dev.coderator.algopractice.exercise._9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

	@Test
	void validate() {

		BinarySearchTree binarySearchTree = new BinarySearchTree(4, 9, 1, 6, 8, 10);
		assertEquals(true, binarySearchTree.isBinarySearchTree());

		binarySearchTree.swapRoot();
		assertEquals(false, binarySearchTree.isBinarySearchTree());
	}
}