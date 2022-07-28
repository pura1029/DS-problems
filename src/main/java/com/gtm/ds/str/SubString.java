package com.gtm.ds.str;

public class SubString {

	public static void print(String str, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcd";
		print(str, str.length());

	}

}
