package com.gtm.ds.arr;

//https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

	static int minSubArrLen(int[] arr, int k) {
		int n = arr.length;
		int l = 0;
		int r = 0;
		int minSize = Integer.MAX_VALUE;
		int sum = 0;

		while (r < n) {
			sum += arr[r];
			if (sum >= k) {
				while (sum >= k) {
					sum -= arr[l];
					l++;
				}
				minSize = Math.min(minSize, (r - l + 1) + 1);
			}
			r++;
		}

		return ((minSize == Integer.MAX_VALUE) ? 0 : minSize);
	}

	static int smallestSubWithSum(int arr[], int n, int x) {
		int min_len = n + 1;

		for (int start = 0; start < n; start++) {
			int curr_sum = arr[start];

			if (curr_sum > x)
				return 1;

			for (int end = start + 1; end < n; end++) {
				curr_sum += arr[end];

				if (curr_sum > x && (end - start + 1) < min_len)
					min_len = (end - start + 1);
			}
		}
		return min_len;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 3, 1, 2, 4, 3 };

		System.out.println(minSubArrLen(arr, 7));
	}

}
