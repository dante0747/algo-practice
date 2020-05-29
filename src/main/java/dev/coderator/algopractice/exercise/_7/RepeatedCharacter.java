package dev.coderator.algopractice.exercise._7;

import java.util.HashSet;

public class RepeatedCharacter {
	public char find(String str) {
		var lowerCaseStr = str.toLowerCase();
		var characterSet = new HashSet<Character>();

		for (var ch : lowerCaseStr.toCharArray())
			if (!characterSet.add(ch))
				return ch;

		throw new IllegalStateException("there's no repeated character");
	}
}
