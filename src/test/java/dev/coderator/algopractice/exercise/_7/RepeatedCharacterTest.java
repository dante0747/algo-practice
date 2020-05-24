package dev.coderator.algopractice.exercise._7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedCharacterTest {

	@Test
	void find() {

		RepeatedCharacter repeatedCharacter = new RepeatedCharacter();
		assertEquals('e', repeatedCharacter.find("A green apple"));
		assertEquals('e', repeatedCharacter.find("Repetition is the path to mastery"));
		assertEquals('n', repeatedCharacter.find("Nothing else matters"));
	}
}