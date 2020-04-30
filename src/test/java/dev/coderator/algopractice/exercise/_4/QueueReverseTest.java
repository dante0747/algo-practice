package dev.coderator.algopractice.exercise._4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QueueReverseTest {

	@Test
	void reverse() {

		QueueReverse queueReverse = new QueueReverse(1, 2, 3, 4, 5);
		queueReverse.reverse();
		assertEquals("[5, 4, 3, 2, 1]", Arrays.toString(queueReverse.toArray()));
	}

	@Test
	void reverse_emptyQueue() {

		QueueReverse queueReverse = new QueueReverse();
		queueReverse.reverse();
		assertEquals("[]", Arrays.toString(queueReverse.toArray()));
	}
}