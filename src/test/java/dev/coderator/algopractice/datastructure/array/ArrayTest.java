package dev.coderator.algopractice.datastructure.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

import dev.coderator.algopractice.datastructure.array.Array;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

	@Test()
	void insert() {

		Array array = sampleArray();

		int[] items = array.items();
		assertEquals(5, items.length);
		assertEquals("[5, 1, 6, 9, 0]", Arrays.toString(items));
	}

	@Test
	void indexOf() {

		Array array = sampleArray();

		assertEquals(3, array.indexOf(9));
		assertEquals(4, array.indexOf(0));
		assertEquals(2, array.indexOf(6));

		NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> array.indexOf(10));
		assertEquals("item not found: 10", ex.getMessage());
	}

	@Test
	void removeAt() {
		Array array = sampleArray();

		array.removeAt(4);
		assertEquals("[5, 1, 6, 9]", Arrays.toString(array.items()));

		array.removeAt(0);
		assertEquals("[1, 6, 9]", Arrays.toString(array.items()));

		array.removeAt(1);
		assertEquals("[1, 9]", Arrays.toString(array.items()));

		array.removeAt(0);
		assertEquals("[9]", Arrays.toString(array.items()));

		array.removeAt(0);
		assertEquals("[]", Arrays.toString(array.items()));

		IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(10));
		assertEquals("index 10 is out of range!", ex.getMessage());
	}

	private Array sampleArray() {
		Array array = new Array(3);
		array.insert(5);
		array.insert(1);
		array.insert(6);
		array.insert(9);
		array.insert(0);
		return array;
	}
}