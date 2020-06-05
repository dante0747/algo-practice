package dev.coderator.algopractice.datastructure.queue;

public class PriorityArrayQueue {

	private int count;
	private int[] items;

	public PriorityArrayQueue(int capacity) {
		items = new int[capacity];
	}

	public void add(int item) {
		if (isFull())
			throw new IllegalStateException("the queue is full!");

		items[shiftItemsToInsert(item)] = item;
		count++;
	}

	private int shiftItemsToInsert(int item) {
		int i;
		for (i = count - 1; i >= 0; i--) {
			if (item < items[i])
				items[i + 1] = items[i];
			else
				break;
		}
		return i + 1;
	}

	public int remove() {
		if (isEmpty())
			throw new IllegalStateException("the queue is empty!");

		return items[--count];
	}


	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == items.length;
	}

	public int[] toArray() {
		var result = new int[count];
		for (var i = 0; i < count; i++)
			result[i] = items[i % count];

		return result;
	}
}
