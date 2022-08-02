package com.gtm.ds.heap;

public class HeapifyArr {

	public static void buildHeap(int arr[], int n) {
		for (int i = n / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[].and n is size of heap
	public static void heapify(int [] arr, int n, int i) {// time complexity : O(n)
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			swap(arr, i, largest);

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; ++i)
			System.out.println(arr[i] + " ");

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 15, 10, 4, 7 };
		int n = arr.length;

		buildHeap(arr, n);

		printArray(arr, n);
	}

}
