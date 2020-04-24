package dev.coderator.algopractice.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

	@Test
	void isBalanced() {

		Expression expression = new Expression();
		assertEquals(true, expression.isBalanced(""));
		assertEquals(false, expression.isBalanced(")][("));
		assertEquals(false, expression.isBalanced("{(1 + 2} * 35)"));
		assertEquals(true, expression.isBalanced("<{(15 + 26)/153}>"));
		assertEquals(true, expression.isBalanced("<><>(([{}]))"));
		assertEquals(false, expression.isBalanced("[](({[{}}}]))"));

		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> expression.isBalanced(null));
		assertEquals("the input expression should not be null!", ex.getMessage());

	}
}