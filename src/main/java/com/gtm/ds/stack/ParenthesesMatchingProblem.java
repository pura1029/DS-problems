package com.gtm.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/valid-parentheses/
//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class ParenthesesMatchingProblem {

	public boolean isValid(String s) {

		Deque<Character> deque = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (isOpeningParentheses(ch)) {
				deque.push(ch);
			} else {

				if (deque.isEmpty()) {
					return false;
				} else if (!isMatching(ch, deque.peek())) {
					return false;
				} else {
					deque.pop();
				}
			}
		}

		return deque.isEmpty();
	}

	private boolean isMatching(char ch, char peek) {

		return ((peek == '(' && ch == ')') || (peek == '{' && ch == '}') || (peek == '[' && ch == ']'));
	}

	private boolean isOpeningParentheses(char ch) {

		return (ch == '(' || ch == '{' || ch == '[');
	}

	public static void main(String[] args) {
		String s = "()[]{}";
		ParenthesesMatchingProblem matchingProblem = new ParenthesesMatchingProblem();
		System.out.println(matchingProblem.isValid(s));
	}

}
