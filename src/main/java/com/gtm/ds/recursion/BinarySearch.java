package com.gtm.ds.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 9, 5, 16, 18, 14 };
		int target = 16;
		int index = search(arr, target, 0, arr.length - 1);
		if (index == -1)
			System.out.println("Not found  :" + target);
		else
			System.out.println("Found on index : " + index);
	}

	// return the index: same as target
	static int search(int[] arr, int target, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = start + (end - start) / 2;

		if (arr[mid] == target) {
			return mid;
		}

		if (target < arr[mid]) {
			return search(arr, target, start, mid - 1);
		}

		return search(arr, target, mid + 1, end);
	}

}
