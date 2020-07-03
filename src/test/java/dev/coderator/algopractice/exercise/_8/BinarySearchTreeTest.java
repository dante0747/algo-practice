package dev.coderator.algopractice.exercise._8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

	@Test
	void equals() {

		assertEquals(true, new BinarySearchTree(4, 9, 1, 6, 8, 10)
				.equals(new BinarySearchTree(4, 9, 1, 6, 8, 10)));

		assertEquals(false, new BinarySearchTree(4, 9, 1, 6, 8, 10)
				.equals(new BinarySearchTree(4, 9, 1, 6, 8)));

		assertEquals(false, new BinarySearchTree(4, 9, 1, 6, 8, 10)
				.equals(new BinarySearchTree(4, 9, 1, 6, 8, 15)));

		assertEquals(true, new BinarySearchTree(1, 2, 3, 4, 5, 6, 7, 8)
				.equals(new BinarySearchTree(1, 2, 3, 4, 5, 6, 7, 8)));
	}
}