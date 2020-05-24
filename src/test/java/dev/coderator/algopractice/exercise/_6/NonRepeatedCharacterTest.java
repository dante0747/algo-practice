package dev.coderator.algopractice.exercise._6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonRepeatedCharacterTest {

	@Test
	void find() {

		NonRepeatedCharacter nonRepeatedCharacter = new NonRepeatedCharacter();
		assertEquals('g', nonRepeatedCharacter.find("A green apple"));
		assertEquals('n', nonRepeatedCharacter.find("Repetition is the path to mastery"));
		assertEquals('o', nonRepeatedCharacter.find("Nothing else matters"));
	}
}