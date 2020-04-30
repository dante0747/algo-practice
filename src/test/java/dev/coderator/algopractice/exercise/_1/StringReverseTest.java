package dev.coderator.algopractice.exercise._1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverseTest {

	@Test
	void reverse() {

		StringReverse stringReverse = new StringReverse();
		assertEquals("", stringReverse.reverse(""));
		assertEquals("ecitcarp-ogla", stringReverse.reverse("algo-practice"));
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> stringReverse.reverse(null));
		assertEquals("input string should not be null!", ex.getMessage());
	}
}