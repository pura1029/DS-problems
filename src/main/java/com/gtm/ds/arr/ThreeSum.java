package com.gtm.ds.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	boolean find3Numbers(int[] arr, int sum) {
		Arrays.sort(arr);
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			int lo = i + 1;
			int hi = n - 1;

			while (lo < hi) {
				if (arr[i] + arr[lo] + arr[hi] == sum) {
					System.out.println("Triplet is " + arr[i] + ", " + arr[lo] + ", " + arr[hi]);
					return true;
				} else if (arr[i] + arr[lo] + arr[hi] < sum) {
					lo++;
				} else {// arr[i]+arr[lo]+arr[hi] > sum
					hi--;
				}
			}
		}

		return false;
	}

	public static List<List<Integer>> threeSum(int[] nums, int eq) {
		Set<List<Integer>> res = new HashSet<>();
		int n = nums.length;
		if (n == 0) {
			return new ArrayList<>(res);
		}
		Arrays.sort(nums);
		for (int i = 0; i < n - 1; i++) {
			int lo = i + 1;
			int hi = n - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum == eq) {
					res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					lo++;
					hi--;
				} else if (sum < eq) {
					lo++;
				} else {// sum > eq
					hi--;
				}
			}
		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		// int[] arr = { 1, 4, 45, 6, 10, 8 };
		int arr[] = { 0, -1, 2, -3, 1 };
		int sum = 0;
		threeSum.find3Numbers(arr, sum);

		System.out.println(threeSum(arr, sum));
	}

}
