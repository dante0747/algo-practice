package dev.coderator.algopractice.exercise._1;

import java.util.Objects;
import java.util.Stack;

public class StringReverse {

	public String reverse(String input) {
		if (Objects.isNull(input))
			throw new IllegalArgumentException("input string should not be null!");

		var letters = new Stack<Character>();
		for (var c : input.toCharArray())
			letters.push(c);

		var builder = new StringBuilder(input.length());
		while (!letters.isEmpty())
			builder.append(letters.pop());

		return builder.toString();
	}
}
