package dev.coderator.algopractice.exercise._5;

import java.util.Arrays;

import dev.coderator.algopractice.datastructure.ArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackifyQueueTest {

	@Test
	void enqueue() {
		StackifyQueue queue = new StackifyQueue();
		assertEquals("[]", Arrays.toString(queue.toArray()));
		queue.enqueue(1);
		assertEquals("[1]", Arrays.toString(queue.toArray()));
		queue.enqueue(2);
		assertEquals("[1, 2]", Arrays.toString(queue.toArray()));
		queue.enqueue(3);
		assertEquals("[1, 2, 3]", Arrays.toString(queue.toArray()));
		queue.enqueue(4);
		assertEquals("[1, 2, 3, 4]", Arrays.toString(queue.toArray()));
		queue.enqueue(5);
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(queue.toArray()));
	}

	@Test
	void dequeue() {
		StackifyQueue queue = queue();
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());
		assertEquals(5, queue.dequeue());
		assertEquals("[]", Arrays.toString(queue.toArray()));
		assertThrows(IllegalStateException.class, () -> queue.dequeue());
	}

	@Test
	void peek() {
		StackifyQueue queue = queue();
		assertEquals(1, queue.peek());
		assertEquals(1, queue.peek());
	}

	@Test
	void isEmpty() {
		StackifyQueue queue = queue();
		assertEquals(false, queue.isEmpty());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}

	private StackifyQueue queue() {

		StackifyQueue arrayQueue = new StackifyQueue();
		arrayQueue.enqueue(1);
		arrayQueue.enqueue(2);
		arrayQueue.enqueue(3);
		arrayQueue.enqueue(4);
		arrayQueue.enqueue(5);

		return arrayQueue;
	}
}