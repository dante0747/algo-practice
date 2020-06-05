package dev.coderator.algopractice.datastructure.stack;

import dev.coderator.algopractice.datastructure.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

	@Test
	void push() {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals(5, stack.size());
		assertThrows(StackOverflowError.class, () -> stack.push(6));
	}

	@Test
	void pop() {

		Stack stack = sampleStack();
		assertEquals(2, stack.pop());
		assertEquals(0, stack.pop());
		assertEquals(3, stack.pop());
		assertEquals(5, stack.pop());
		IllegalStateException ex = assertThrows(IllegalStateException.class, () -> stack.pop());
		assertEquals("stack is empty!", ex.getMessage());
	}

	@Test
	void peek() {

		Stack stack = sampleStack();
		assertEquals(2, stack.peek());
		assertEquals(2, stack.peek());
		assertEquals(2, stack.peek());
	}

	@Test
	void isEmpty() {
		Stack stack = sampleStack();
		assertEquals(false, stack.isEmpty());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}

	private Stack sampleStack() {
		Stack stack = new Stack();
		stack.push(5);
		stack.push(3);
		stack.push(0);
		stack.push(2);
		return stack;
	}
}