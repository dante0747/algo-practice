package dev.coderator.algopractice.exercise._3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

	@Test
	void kthFromTheEnd() {
		assertEquals(8, list().kthFromTheEnd(1));
		assertEquals(5, list().kthFromTheEnd(5));
		assertEquals(15, list().kthFromTheEnd(9));
		assertThrows(IllegalArgumentException.class, () -> list().kthFromTheEnd(-1));
		assertThrows(IllegalArgumentException.class, () -> list().kthFromTheEnd(0));
		assertThrows(IllegalArgumentException.class, () -> list().kthFromTheEnd(100));
		assertThrows(IllegalStateException.class, () -> new LinkedList().kthFromTheEnd(2));
	}

	private LinkedList list() {
		return new LinkedList(15, -6, 9, 1, 5, 2, 0, -1, 8);
	}
}