package dev.coderator.algopractice.exercise._7;

import java.util.Set;
import java.util.HashSet;

public class RepeatedCharacter {
	public char find(String str) {
		String lowerCaseStr = str.toLowerCase();
		Set<Character> characterSet = new HashSet<>();

		for (char ch : lowerCaseStr.toCharArray())
			if (!characterSet.add(ch))
				return ch;

		throw new IllegalStateException("there's no repeated character");
	}
}
