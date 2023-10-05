package com.gtm.ds.str;

public class Permutation {

	/**
	 * permutation function
	 * 
	 * @param str string to calculate permutation for
	 * @param l   starting index
	 * @param r   end index
	 *https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	 */
	private void permute(String str, int l, int r) {
		if (l == r) {
			System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public void permute(String s, String answer) {
		if (s.length() == 0) {
			System.out.print(answer + "  ");
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String left_substr = s.substring(0, i);
			String right_substr = s.substring(i + 1);
			String rest = left_substr + right_substr;
			permute(rest, answer + ch);
		}
	}

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n - 1);
		System.out.println("==========================================");
		permutation.permute(str, "");

	}
}
