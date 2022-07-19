package com.gtm.ds.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
public class TripletsWithZeroSum {

	// function to print triplets with 0 sum
	static void findTriplets(int arr[], int n) {
		boolean found = false;
		for (int i = 0; i < n - 1; i++) {
			// Find all pairs with sum equals to
			// "-arr[i]"
			Set<Integer> s = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int x = -(arr[i] + arr[j]);// a+b+c=0 => a = -(a+b)
				if (s.contains(x)) {
					System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
					found = true;
				} else {
					s.add(arr[j]);
				}
			}
		}

		if (found == false) {
			System.out.printf(" No Triplet Found\n");
		}
	}

	static boolean find3Numbers(int[] arr, int sum) {
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			int lo = i + 1;
			int hi = n - 1;

			while (lo < hi) {
				if (arr[i] + arr[lo] + arr[hi] == sum) {
					System.out.print("Triplet is " + arr[i] + ", " + arr[lo] + ", " + arr[hi]);
					return true;
				} else if (arr[i] + arr[lo] + arr[hi] < sum) {
					lo++;
				} else {// arr[i]+arr[lo]+arr[hi] > sum
					hi--;
				}
			}
		}
		System.out.printf(" No Triplet Found\n");
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 0, -1, 2, -3, 1 };
		int n = arr.length;
		findTriplets(arr, n);
		find3Numbers(arr, 0);
	}

}
