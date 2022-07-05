package com.gtm.palindromes;

public class AllPalindromes {

	public static void printAllPalindrome(String str) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < str.length(); i++) 
			for (int j = i+1; j < str.length(); j++) 
				if(str.substring(i,j+1).length() > 2 && checkPalindrome(str.substring(i,j+1)))
					System.out.println(str.substring(i,j+1));
		long end = System.currentTimeMillis();
		System.out.println("Time taken "+(end-start)+" miliseconds");
	}

	public static boolean checkPalindrome(String str) {
		for (int i = 0; i <= str.length()/2; i++) 
			if(str.charAt(i) != str.charAt(str.length()-i-1))
				return false;
		return true;
	}

	/**
	 * permutation function
	 * @param str string to calculate permutation for
	 * @param l starting index
	 * @param r end index
	 */
	private static void permute(String str, int l, int r)
	{
		if (l == r){
			System.out.println("AllPalindromes.permute()"+str);
			if(checkPalindrome(str))
				System.out.println(str);
		}
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str,l,i);
				permute(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public static String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}


	public static void main(String[] args) {
		String str = "abbaallaaabbllaabbaabblllaabbbaaabblldllbb";
		printAllPalindrome(str);
		System.out.println("==============================");
		str = "abcd";
		int n = str.length();
		//permute(str, 0, n-1);
	}

}
