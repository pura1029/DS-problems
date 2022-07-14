package com.gtm.ds.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/smaller-on-left20360700/1
//https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1/
//Previous(left) or Next(right) smallest and biggest element in Array.
public class SmallerOnLeft {

	public static int[] smallestOnLeft(int arr[], int n) {
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

	public static int[] biggestOnLeft(int arr[], int n) {
		int[] res = new int[n];

		Deque<Integer> stack = new LinkedList<>();

		for (int i = 0; i < n; i++) {

			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
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

	public static int[] smallestOnRight(int arr[], int n) {
		int[] res = new int[n];

		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = n - 1; i >= 0; i--) {

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

	public static int[] biggestOnRight(int arr[], int n) {
		int[] res = new int[n];

		Deque<Integer> stack = new LinkedList<>();

		for (int i = n - 1; i >= 0; i--) {

			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
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
		int[] arr = { 2, 3, 1, 4, 5, 0 };
		System.out.println(Arrays.toString(smallestOnLeft(arr, arr.length)));

		System.out.println(Arrays.toString(biggestOnLeft(arr, arr.length)));

		System.out.println(Arrays.toString(smallestOnRight(arr, arr.length)));

		System.out.println(Arrays.toString(biggestOnRight(arr, arr.length)));
	}
}
