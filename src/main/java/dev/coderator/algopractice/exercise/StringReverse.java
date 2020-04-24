package dev.coderator.algopractice.exercise;

import java.util.Objects;
import java.util.Stack;

public class StringReverse {

	public String reverse(String input) {
		if (Objects.isNull(input))
			throw new IllegalArgumentException("input string should not be null!");

		Stack<Character> letters = new Stack<>();
		for (char c : input.toCharArray())
			letters.push(c);

		StringBuilder builder = new StringBuilder(input.length());
		while (!letters.isEmpty())
			builder.append(letters.pop());

		return builder.toString();
	}
}
