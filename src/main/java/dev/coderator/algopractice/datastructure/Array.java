package dev.coderator.algopractice.datastructure;

import java.util.NoSuchElementException;

public class Array {

	private int count;
	private int[] items;

	public Array(int size) {
		items = new int[size];
	}

	public void insert(int number) {
		if (items.length == count)
			reconstruct();

		items[count++] = number;
	}

	private void reconstruct() {
		int[] tmpArray = new int[items.length * 2];
		for (int i = 0; i < items.length; i++)
			tmpArray[i] = items[i];

		items = tmpArray;
	}

	public int indexOf(int number) {
		for (int i = 0; i < items.length; i++)
			if (items[i] == number)
				return i;

		throw new NoSuchElementException(String.format("item not found: %d", number));
	}

	public void removeAt(int index) {
		if (index >= count || index < 0)
			throw new IndexOutOfBoundsException(String.format("index %d is out of range!", index));

		for (int i = index; i < items.length - 1; i++)
			items[i] = items[i + 1];
		count--;
	}

	public int[] items() {
		int[] tmpArray = new int[count];
		for (int i = 0; i < count; i++)
			tmpArray[i] = items[i];

		return tmpArray;
	}
}
