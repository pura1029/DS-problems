package com.gtm.ds.arr;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {

	public static int singleNonDuplicate1(int[] nums) {
		int ans = -1;
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		for (int i = 0; i < n - 1; i += 2) {
			if (nums[i] != nums[i + 1]) {
				ans = nums[i];
				break;
			}
		}
		if (ans == -1 && nums[n - 2] != nums[n - 1]) {
			ans = nums[n - 1];
		}
		return ans;
	}

	public static int singleNonDuplicate(int[] nums) {
		int start = 0;
		int n = nums.length;
		int end = n - 1;
		if (n == 1) {
			return nums[0];
		}
		if (nums[start] != nums[start + 1]) {
			return nums[start];
		}
		if (nums[end] != nums[end - 1]) {
			return nums[end];
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
				return nums[mid];
			} else if ((nums[mid] == nums[mid + 1] && mid % 2 == 0) || (nums[mid] == nums[mid - 1] && mid % 2 != 0)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// int a[] = { 1, 1, 2 };
		int a[] = { 1, 1, 2, 2, 4, 4, 5 };
		System.out.println(singleNonDuplicate(a));

	}

}
