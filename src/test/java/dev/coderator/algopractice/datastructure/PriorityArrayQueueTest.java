package dev.coderator.algopractice.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PriorityArrayQueueTest {

	@Test
	void add() {
		PriorityArrayQueue priorityArrayQueue = priorityArrayQueue();
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(priorityArrayQueue.toArray()));
		assertThrows(IllegalStateException.class, () -> priorityArrayQueue.add(6));
	}

	@Test
	void remove() {
		int count = 5;
		PriorityArrayQueue priorityArrayQueue = priorityArrayQueue();
		while (!priorityArrayQueue.isEmpty())
			assertEquals(count--, priorityArrayQueue.remove());
	}

	@Test
	void isEmpty() {
		PriorityArrayQueue priorityArrayQueue = new PriorityArrayQueue(5);
		assertEquals(true, priorityArrayQueue.isEmpty());
		priorityArrayQueue.add(1);
		assertEquals(false, priorityArrayQueue.isEmpty());
	}

	@Test
	void isFull() {
		assertEquals(true, priorityArrayQueue().isFull());
	}

	private PriorityArrayQueue priorityArrayQueue() {
		PriorityArrayQueue priorityArrayQueue = new PriorityArrayQueue(5);
		priorityArrayQueue.add(5);
		priorityArrayQueue.add(2);
		priorityArrayQueue.add(1);
		priorityArrayQueue.add(3);
		priorityArrayQueue.add(4);
		return priorityArrayQueue;
	}
}