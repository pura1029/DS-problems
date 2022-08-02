package com.gtm.ds.sorting;

import com.gtm.ds.heap.HeapifyArr;

public class HeapSort {

	public static void sort(int[] arr, int n) { // time complexity : O(n) + O(nlogn) = O(nlogn)
		HeapifyArr.buildHeap(arr, n);// time complexity : O(n)

		for (int i = n - 1; i >= 0; i--) {// time complexity : O(nlogn)
			HeapifyArr.swap(arr, i, 0);
			HeapifyArr.heapify(arr, i - 1, 0);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 15, 10, 4, 7 };
		int n = arr.length;
		sort(arr, n);

		HeapifyArr.printArray(arr, n);
	}

}
