package dev.coderator.algopractice.exercise._6;

import java.util.LinkedHashMap;

public class NonRepeatedCharacter {
	public char find(String str) {
		String lowerCaseStr = str.toLowerCase();
		var characterMap = new LinkedHashMap<Character, Integer>();

		for (var ch : lowerCaseStr.toCharArray())
			characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);

		for (var key : characterMap.keySet())
			if (characterMap.get(key) == 1)
				return key;

		throw new IllegalStateException("there's no non-repeated character");
	}
}
