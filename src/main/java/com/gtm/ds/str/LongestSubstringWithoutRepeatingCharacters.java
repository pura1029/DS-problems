package com.gtm.ds.str;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int longestUniqueSubsttr(String s) {
		int n = s.length();

		int res = 0;

		for (int i = 0; i < n; i++) {

			boolean[] visited = new boolean[256];

			for (int j = i + 1; j < n; j++) {

				if (visited[s.charAt(j)]) {
					break;
				} else {
					res = Math.max(res, j - i);
					visited[s.charAt(j)] = true;
				}
			}

			// Remove the first character of previous
			// window
			visited[s.charAt(i)] = false;
		}
		return res;
	}

	public static int lengthOfLongestSubstring(String s) {
		int res = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				String subStr = s.substring(i, j);
				if (isDistinct(subStr)) {
					res = Math.max(res, (j - i));
				}
			}
		}
		return res;
	}

	private static boolean isDistinct(String subStr) {
		boolean[] visited = new boolean[256];

		for (int i = 0; i < subStr.length(); i++) {
			if (visited[subStr.charAt(i)]) {
				return false;
			}
			visited[subStr.charAt(i)] = true;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";// output : 3

		System.out.println(longestUniqueSubsttr(s));

	}

}
