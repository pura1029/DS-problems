package com.gtm.ds.sorting;

import java.util.Arrays;
//https://www.youtube.com/watch?v=QXum8HQd_l4&ab_channel=ApnaCollege
//https://www.geeksforgeeks.org/quick-sort/
public class QuickSort {

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			// pivotIndex is partitioning index, arr[pivotIndex]
			// is now at right place
			int pivotIndex = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			sort(arr, low, pivotIndex - 1);
			sort(arr, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// pivot
		int pivot = arr[high];

		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = low - 1;

		for (int j = low; j < high; j++) {
			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {
				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, i, high);// put pivot to right place

		return i;// pivot index;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 1, 2, 6, 4 };

		sort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}

}
