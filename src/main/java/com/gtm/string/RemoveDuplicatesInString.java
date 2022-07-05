package com.gtm.string;

import java.util.Arrays;

public class RemoveDuplicatesInString {
	/* Method to remove duplicates in a sorted array */
	static String removeDupsSorted(String str)
	{
		int i = 1, j = 1;

		// Character array for removal of duplicate characters
		char arr[] = str.toCharArray();

		/* In place removal of duplicate characters*/
		while (j != arr.length) //aab
		{
			if(arr[j] != arr[j-1])
			{
				arr[i] = arr[j];
				i++;
			}
			j++;

		}

		str = new String(arr);
		return str.substring(0,i);
	}

	/* Method removes duplicate characters from the string
       This function work in-place and fills null characters
       in the extra space left */
	static String removeDups(String str)
	{
		// Sort the character array
		char temp[] = str.toCharArray();
		//Arrays.sort(temp);
		sortString(temp);
		str = new String(temp);

		// Remove duplicates from sorted
		return removeDupsSorted(str);
	}

	static String removeDups1(String str)
	{
		char[] c = str.toCharArray();
		int n = c.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(c[i] == c[j]){
					c[j] = c[n-1];
					n--;
					j--;
				}
			}
		}
		return new String(Arrays.copyOf(c, n));
	}

	private static void sortString(char [] c){
		int i, j;
		for (i = 1; i < c.length; i++) {
			int key = (int)c[i];
			j = i-1;
			while (j >= 0 && c[j] > key) {
				c[j+1] = c[j];
				j = j-1;
			}
			c[j+1] = (char)key;
		}
	}

	private static void sortInt(int [] c){
		int i, j;
		for (i = 1; i < c.length; i++) {
			int key = c[i];
			j = i-1;
			while (j >= 0 && c[j] > key) {
				c[j+1] = c[j];
				j = j-1;
			}
			c[j+1] = key;
		}
	}
	// Driver Method
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println(removeDups1(str));
		char c[] = str.toCharArray();
		sortString(c);
		System.out.println(new String(c));
		int a[] = new int[]{5,3,1,2,6,4};
		sortInt(a);
		for (int i : a) {
			System.out.print(i+" ");
		}

	}
}
