package com.gtm.ds.str;

import java.util.Stack;

public class LexicographicallyLargest {

//https://leetcode.com/problems/remove-duplicate-letters/
	// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
	public static String smallestSubsequence(String s) {
		int[] last_index_of = new int[26];
		int s_length = s.length();

		for (int i = 0; i < s_length; i++) {
			last_index_of[s.charAt(i) - 'a'] = i;
		}

		boolean[] visited = new boolean[26];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s_length; i++) {
			char cur_char = s.charAt(i);
			if (visited[cur_char - 'a'])
				continue;
			while (!stack.isEmpty() && stack.peek() > cur_char && last_index_of[stack.peek() - 'a'] > i) {
				char remove = stack.pop();
				visited[remove - 'a'] = false;
			}
			stack.push(cur_char);
			visited[cur_char - 'a'] = true;
		}
		String output = "";
		while (!stack.isEmpty()) {
			output = stack.pop() + output;
		}
		return output;
	}

	public static void main(String[] args) {

		// String str = "bcabc";// o/p: "abc"

		String str = "cbacdcbc"; // o/p : "acdb"

		System.out.println(smallestSubsequence(str));
	}
}
