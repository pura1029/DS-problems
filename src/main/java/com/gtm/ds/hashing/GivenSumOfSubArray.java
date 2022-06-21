package com.gtm.ds.hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
public class GivenSumOfSubArray {

	static int[] subArraySum(int arr[], int sum) {
		int start = 0;
		int end = -1;
		for (int i = 0; i < arr.length; i++) {
			int currSum = 0;
			for (int j = i; j < arr.length; j++) {
				currSum += arr[j];
				if (currSum == sum) {
					start = i;
					end = j;
					break;
				}
			}
			if (end != -1) {
				break;
			}
		}

		return new int[] { start, end };
	}

	static int[] subArraySumHash(int arr[], int sum) {
		int currSum = 0;
		int start = 0;
		int end = -1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];

			if ((currSum - sum) == 0) {
				start = 0;
				end = i;
			}

			if (map.containsKey((currSum - sum))) {
				start = map.get((currSum - sum)) + 1; 
				end = i;
				break;
			}
			map.put(currSum, i);
		}
		return new int[] { start, end };
	}

	// count sub arr for given sum
	// https://leetcode.com/problems/subarray-sum-equals-k/
	public int subarraySum(int[] nums, int k) {
		int currSum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];

			if ((currSum - k) == 0) {
				count++;
			}

			if (map.containsKey((currSum - k))) {
				count += map.get(currSum - k);
			}
			map.put(currSum, (map.getOrDefault(currSum, 0) + 1));
		}
		return count;
	}

	public static void main(String[] args) {
		// int[] arr = { 10, 2, -2, -20, 10 };
		int[] arr = { 10, 15, -5, -10, 15 };// 10-0, 25-1, 20-2,10-3,25-4
		int sum = 5;
		int[] res = subArraySum(arr, sum);
		if (res[1] == -1) {
			System.out.println("Not found");
		} else {
			System.out.print("Sum found between indexes " + res[0] + " and " + res[1]);
		}

	}

}
