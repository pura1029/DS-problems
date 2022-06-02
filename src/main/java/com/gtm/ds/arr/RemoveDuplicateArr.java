package com.gtm.ds.arr;

import java.util.Arrays;

public class RemoveDuplicateArr {

	static int[] removeDup(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j++] = arr[i];
			}
		}

		arr[j++] = arr[n - 1];

		return Arrays.copyOf(arr, j);
	}

	public static void main(String[] args) {
		int[] a = { 5, 10, 15, 5, 4, 15 };

		System.out.println(Arrays.toString(removeDup(a)));
	}

}
