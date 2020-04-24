package dev.coderator.algopractice.exercise;

import java.util.*;

public class Expression {

	private static final List<Character> leftBrackets = Arrays.asList('[', '{', '<', '(');
	private static final List<Character> rightBrackets = Arrays.asList(']', '}', '>', ')');

	public boolean isBalanced(String expression) {
		if (Objects.isNull(expression))
			throw new IllegalArgumentException("the input expression should not be null!");

		Stack<Character> stack = new Stack<>();

		for (char ch : expression.toCharArray())
			if (isLeftBracket(ch))
				stack.push(ch);
			else if (isRightBracket(ch)) {
				if (stack.isEmpty() || !match(stack.pop(), ch))
					return false;
			}

		return true;
	}

	private boolean isRightBracket(char c) {
		return rightBrackets.contains(c);
	}

	private boolean isLeftBracket(char c) {
		return leftBrackets.contains(c);
	}

	private boolean match(char left, char right) {
		return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
	}
}
