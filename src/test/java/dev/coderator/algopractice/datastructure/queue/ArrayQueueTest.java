package dev.coderator.algopractice.datastructure.queue;

import dev.coderator.algopractice.datastructure.queue.ArrayQueue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

	@Test
	void enqueue() {
		ArrayQueue arrayQueue = new ArrayQueue(5);
		assertEquals("[]", Arrays.toString(arrayQueue.toArray()));
		arrayQueue.enqueue(1);
		assertEquals("[1]", Arrays.toString(arrayQueue.toArray()));
		arrayQueue.enqueue(2);
		assertEquals("[1, 2]", Arrays.toString(arrayQueue.toArray()));
		arrayQueue.enqueue(3);
		assertEquals("[1, 2, 3]", Arrays.toString(arrayQueue.toArray()));
		arrayQueue.enqueue(4);
		assertEquals("[1, 2, 3, 4]", Arrays.toString(arrayQueue.toArray()));
		arrayQueue.enqueue(5);
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(arrayQueue.toArray()));
		assertThrows(IllegalStateException.class, () -> arrayQueue.enqueue(6));
	}

	@Test
	void dequeue() {
		ArrayQueue arrayQueue = queue();
		assertEquals(1, arrayQueue.dequeue());
		assertEquals(2, arrayQueue.dequeue());
		assertEquals(3, arrayQueue.dequeue());
		assertEquals(4, arrayQueue.dequeue());
		assertEquals(5, arrayQueue.dequeue());
		assertEquals("[]", Arrays.toString(arrayQueue.toArray()));
		assertThrows(IllegalStateException.class, () -> arrayQueue.dequeue());
	}

	@Test
	void peek() {
		ArrayQueue arrayQueue = queue();
		assertEquals(1, arrayQueue.peek());
		assertEquals(1, arrayQueue.peek());
	}

	@Test
	void isEmpty() {
		ArrayQueue arrayQueue = queue();
		assertEquals(false, arrayQueue.isEmpty());
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		assertEquals(true, arrayQueue.isEmpty());
	}

	@Test
	void isFull() {
		ArrayQueue arrayQueue = queue();
		assertEquals(true, arrayQueue.isFull());
		arrayQueue.dequeue();
		assertEquals(false, arrayQueue.isFull());
	}

	private ArrayQueue queue() {

		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue(1);
		arrayQueue.enqueue(2);
		arrayQueue.enqueue(3);
		arrayQueue.enqueue(4);
		arrayQueue.enqueue(5);

		return arrayQueue;
	}
}