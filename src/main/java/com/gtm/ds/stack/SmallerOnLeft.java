package com.gtm.ds.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/smaller-on-left20360700/1
//https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1/
public class SmallerOnLeft {

	public static int[] smallestonleft(int arr[], int n) {
		int[] res = new int[n];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {

			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = stack.peek();
			}

			stack.push(arr[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 1 };
		System.out.println(Arrays.toString(smallestonleft(arr, arr.length)));
	}
}
