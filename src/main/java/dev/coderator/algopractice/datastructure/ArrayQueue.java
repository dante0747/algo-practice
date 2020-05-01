package dev.coderator.algopractice.datastructure;

public class ArrayQueue {

	private int rear;
	private int front;
	private int count;

	private int[] items;

	public ArrayQueue(int capacity) {
		items = new int[capacity];
	}

	public void enqueue(int item) {
		if (isFull())
			throw new IllegalStateException();

		items[rear] = item;
		rear = (rear + 1) % items.length;
		count++;
	}

	public int dequeue() {
		if (isEmpty())
			throw new IllegalStateException();

		int value = items[front];
		front = (front + 1) % items.length;
		count--;

		return value;
	}

	public int peek() {
		return items[front];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == items.length;
	}

	public int[] toArray() {
		int[] result = new int[count];
		for (int i = 0; i < count; i++)
			result[i] = items[i % count];

		return result;
	}
}
