package com.gtm.ds.str;

//https://www.geeksforgeeks.org/longest-prefix-also-suffix/
//https://leetcode.com/problems/longest-happy-prefix/
public class LongestPrefixSuffix {

	public static String longestPrefix(String s) {
		int n = s.length();
		if (n < 2) {
			return "";
		}
		int[] lps = new int[n];
		int j = 0;
		int i = 1;
		lps[0] = 0;
		while (i < n) {
			if (s.charAt(j) == s.charAt(i)) {
				++j;
				lps[i] = j;
				i++;
			} else if (j > 0) {
				j = lps[j - 1];
			} else {
				lps[i] = 0;
				i++;
			}
		}
		return s.substring(0, j);
	}

	public static void main(String[] args) {
		//String s = "level"// Output: "l"
		String s = "ababab";// Output: "abab"
		//String s = "abcab";// Output: "ab"

		System.out.println(longestPrefix(s));
	}

}
