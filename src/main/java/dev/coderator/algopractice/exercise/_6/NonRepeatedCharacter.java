package dev.coderator.algopractice.exercise._6;

import java.util.Map;
import java.util.LinkedHashMap;

public class NonRepeatedCharacter {
	public char find(String str) {
		String lowerCaseStr = str.toLowerCase();
		Map<Character, Integer> characterMap = new LinkedHashMap<>();

		for (char ch : lowerCaseStr.toCharArray())
			characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);

		for (char key : characterMap.keySet())
			if (characterMap.get(key) == 1)
				return key;

		throw new IllegalStateException("there's no non-repeated character");
	}
}
