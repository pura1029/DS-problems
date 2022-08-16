package com.gtm.ds.heap;
//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

	static void printKMax(int arr[], int n, int k) {
		int j, max;

		for (int i = 0; i <= n - k; i++) {

			max = arr[i];

			for (j = 1; j < k; j++) {
				if (arr[i + j] > max) {
					max = arr[i + j];
				}
			}
			System.out.print(max + " ");
		}

		System.out.println();
	}

	static List<Integer> findKMaxElement(int[] arr, int k, int n) {
		// creating the max heap ,to get max element always
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		ArrayList<Integer> res = new ArrayList<>();
		int i = 0;

		for (; i < k; i++) {
			queue.add(arr[i]);
		}

		// adding the maximum element among first k elements
		res.add(queue.peek());

		// removing the first element of the array
		queue.remove(arr[0]);

		// iterarting for the next elements
		for (; i < n; i++) {

			// adding the new element in the window
			queue.add(arr[i]);

			// finding & adding the max element in the
			// current sliding window
			res.add(queue.peek());

			// finally removing the first element from front
			// end of queue
			queue.remove(arr[i - k + 1]);
		}

		return res;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
		printKMax(arr, arr.length, k);
		System.out.println(findKMaxElement(arr, k, arr.length));
	}

}
