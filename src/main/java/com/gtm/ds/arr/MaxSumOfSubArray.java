package com.gtm.ds.arr;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//Kadane’s Algorithm:
public class MaxSumOfSubArray {

	static int maxSum(int[] a) {
		int maxSum = a[0];
		int currSum = 0;
		for (int i = 0; i < a.length; i++) {
			currSum += a[i];
			if (currSum > maxSum) {
				maxSum = currSum;
			}
			if (currSum < 0) {
				currSum = 0;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxSum(a));

	}

}
