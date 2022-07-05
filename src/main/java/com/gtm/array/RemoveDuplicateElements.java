package com.gtm.array;

import java.util.Arrays;

public class RemoveDuplicateElements {


	// Function to remove duplicate elements
	// This function returns new size of modified
	// array.
	static int removeDuplicates(int arr[], int n)
	{
		if(n == 0 || n == 1)
			return n;
		// To store index of next unique element
		int j = 0;
		// If current element is not equal
		// to next element then store that
		// current element
		for (int i = 0; i < n-1; i++) 
			if(arr[i] != arr[i+1])
				arr[j++] = arr[i];

		// Store the last element as whether
		// it is unique or repeated, it hasn't
		// stored previously
		arr[j++] = arr[n-1];
		return j;
	}

	static String removeDuplicatesCar(String s){
		char ch[] = s.toCharArray();
		int n = ch.length;
		if(n == 0 || n == 1)
			return s;
		int j = 0;
		for (int i = 0; i < n-1; i++) 
			if(ch[i] != ch[i+1])
				ch[j++] = ch[i];

		ch[j++] = ch[n-1];
		ch = Arrays.copyOf(ch, j);	
		return String.valueOf(ch);
	}

	static int removeDuplicates1(int arr[], int n)
	{
		if(n == 0 || n == 1)
			return n;
		int i = 1, j = 0;

		while (i  < n) {
			if (arr[j] == arr[i]) {
				i++;
			} else {
				arr[++j] = arr[i++];
			}
		}
		return j+1;
	}

	static int removeDuplicates2(int arr[], int n)
	{
		if(n == 0 || n == 1)
			return n;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1 ; j < n; j++) {
				if (arr[i] == (arr[j])) {
					// got the duplicate element
					arr[j] = arr[n-1];
					n--;
					j--;
				}
			}
		}
		return n;
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
		int arr1[] = {3,3,1,2,2,1, 4, 5, 5,4};
		int n = arr.length;
		int n1 = arr1.length;

		n = removeDuplicates(arr, n);

		// Print updated array
		for (int i=0; i<n; i++)
			System.out.print(arr[i]+" ");

		System.out.println("\n"+removeDuplicatesCar("abccdddee"));

		int n2 = removeDuplicates1(arr, n);
		System.out.println("using removeDuplicates1 :");
		// Print updated array
		for (int i=0; i<n2; i++)
			System.out.print(arr[i]+" ");

		int n3 = removeDuplicates2(arr1, n1);
		System.out.println("\nusing removeDuplicates2 :");
		// Print updated array
		for (int i=0; i<n3; i++)
			System.out.print(arr1[i]+" ");

	}

}
