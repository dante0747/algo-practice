package dev.coderator.algopractice.datastructure.tree;

import dev.coderator.algopractice.datastructure.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

	@Test
	void exists() {
		Tree tree = binarySearchTree();
		assertEquals(true, tree.exists(8));
		assertEquals(false, tree.exists(0));
		assertEquals(true, tree.exists(10));
		assertEquals(false, tree.exists(-1));
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
		Tree tree = binarySearchTree();
		assertEquals(2, tree.height());

		tree.insert(20);
		assertEquals(3, tree.height());

		tree.insert(0);
		assertEquals(3, tree.height());

		tree.insert(13);
		assertEquals(4, tree.height());

		tree.insert(12);
		assertEquals(5, tree.height());

		tree.insert(14);
		assertEquals(5, tree.height());
	}

	@Test
	void minValue(){
		Tree tree = binarySearchTree();
		assertEquals(1, tree.min());

		tree.insert(20);
		assertEquals(1, tree.min());

		tree.insert(-100);
		assertEquals(-100, tree.min());
	}

	private Tree binarySearchTree() {
		Tree tree = new Tree(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);

		return tree;
	}
}