package dev.coderator.algopractice.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


	@Test
	void addFirst() {
		LinkedList list = new LinkedList();

		list.addFirst(5);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(0);
		list.addFirst(9);
		assertEquals("[9, 0, 1, 2, 5]", Arrays.toString(list.toArray()));
	}

	@Test
	void addLast() {
		LinkedList list = new LinkedList();

		list.addLast(5);
		list.addLast(2);
		list.addLast(1);
		list.addLast(0);
		list.addLast(9);
		assertEquals("[5, 2, 1, 0, 9]", Arrays.toString(list.toArray()));
	}

	@Test
	void indexOf() {
		LinkedList list = list();
		//[15, -6, 9, 1, 5, 2, 0, -1, 8]
		assertEquals(0, list.indexOf(15));
		assertEquals(3, list.indexOf(1));
		assertEquals(7, list.indexOf(-1));
		assertEquals(4, list.indexOf(5));
		assertEquals(8, list.indexOf(8));

		NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> list.indexOf(11));
		assertEquals("item not found: 11", ex.getMessage());
	}

	@Test
	void contains() {
		LinkedList list = list();
		assertEquals(true, list.contains(9));
		assertEquals(false, list.contains(6));
		assertEquals(true, list.contains(8));
		assertEquals(true, list.contains(2));
		assertEquals(false, list.contains(3));
	}

	@Test
	void removeFirst() {
		LinkedList list = list();
		//[15, -6, 9, 1, 5, 2, 0, -1, 8]
		for (int i = 0; i < 5; i++)
			list.removeFirst();
		assertEquals("[2, 0, -1, 8]", Arrays.toString(list.toArray()));

		for (int i = 0; i < 3; i++)
			list.removeFirst();
		assertEquals("[8]", Arrays.toString(list.toArray()));

		list.removeFirst();
		assertEquals("[]", Arrays.toString(list.toArray()));

		NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> list.removeFirst());
		assertEquals("the linked list is empty!", ex.getMessage());
	}

	@Test
	void removeLast() {
		LinkedList list = list();
		//[15, -6, 9, 1, 5, 2, 0, -1, 8]
		for (int i = 0; i < 5; i++)
			list.removeLast();
		assertEquals("[15, -6, 9, 1]", Arrays.toString(list.toArray()));

		for (int i = 0; i < 3; i++)
			list.removeLast();
		assertEquals("[15]", Arrays.toString(list.toArray()));

		list.removeLast();
		assertEquals("[]", Arrays.toString(list.toArray()));

		NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> list.removeLast());
		assertEquals("the linked list is empty!", ex.getMessage());
	}

	@Test
	void size() {
		LinkedList list = list();
		//[15, -6, 9, 1, 5, 2, 0, -1, 8]
		assertEquals(9, list.size());
	}

	@Test
	void toArray() {
		assertEquals("[15, -6, 9, 1, 5, 2, 0, -1, 8]", Arrays.toString(list().toArray()));
	}

	@Test
	void reverse() {
		LinkedList list = list();
		list.reverse();
		assertEquals("[8, -1, 0, 2, 5, 1, 9, -6, 15]", Arrays.toString(list.toArray()));
		assertEquals("[]", Arrays.toString(new LinkedList().toArray()));

		list = new LinkedList();
		list.addFirst(1);
		list.reverse();
		assertEquals("[1]", Arrays.toString(list.toArray()));
	}

	private LinkedList list() {
		LinkedList list = new LinkedList();

		list.addFirst(5); //[5]
		list.addLast(2); //[5, 2]
		list.addFirst(1); //[1, 5, 2]
		list.addLast(0); //[1, 5, 2, 0]
		list.addFirst(9); //[9, 1, 5, 2, 0]
		list.addLast(-1); //[9, 1, 5, 2, 0, -1]
		list.addFirst(-6); //[-6, 9, 1, 5, 2, 0, -1]
		list.addLast(8); //[-6, 9, 1, 5, 2, 0, -1, 8]
		list.addFirst(15); //[15, -6, 9, 1, 5, 2, 0, -1, 8]

		return list;
	}
}