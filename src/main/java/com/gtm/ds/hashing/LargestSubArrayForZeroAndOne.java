package com.gtm.ds.hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
//https://leetcode.com/problems/contiguous-array/
public class LargestSubArrayForZeroAndOne {

	static int subArraySum(int arr[]) {
		int maxSize = 0;
		for (int i = 0; i < arr.length; i++) {
			int zeroes = 0, ones = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] == 0) {
					zeroes++;
				} else {
					ones++;
				}
				if (ones == zeroes) {
					maxSize = Math.max(maxSize, (j - i + 1));
				}
			}
		}
		return maxSize;
	}

	static int subArraySumHash(int[] arr) {
		int currSum = 0;
		int start = 0;
		int end = -1;
		int maxSize = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i] == 0 ? -1 : 1;

			if (currSum == 0) {
				start = 0;
				end = i;
				if ((end - start + 1) > maxSize) {
					maxSize = (end - start + 1);
				}
			}

			if (map.containsKey((currSum))) {
				start = map.get((currSum)) + 1;
				end = i;
				if ((end - start + 1) > maxSize) {
					maxSize = (end - start + 1);
				}
			} else {
				map.put(currSum, i);
			}
		}
		return maxSize;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0 };
		int res = subArraySumHash(arr);
		System.out.println(res);
	}

}
