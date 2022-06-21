package com.gtm.ds.arr;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumberInArr {
	// if Arr is Immutable
	static int findDup(int[] arr) {
		int slow = arr[0];
		int fast = arr[0];
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		} while (slow != fast);

		fast = arr[0];

		while (slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}

		return slow;
	}

	public static int findDuplicate(int[] nums) {
		int[] temp = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			if (temp[nums[i]] == 1) {
				return nums[i];
			} else {
				temp[nums[i]] = 1;
			}
		}

		return -1;
	}

	public static int findDuplicate1(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				return Math.abs(nums[i]);
			} else {
				nums[index] *= -1;
			}
		}
		return -1;
	}

	// https://leetcode.com/problems/find-all-duplicates-in-an-array/
	public List<Integer> findDuplicates1(int[] nums) {
		int[] temp = new int[nums.length + 1];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (temp[nums[i]] == 1) {
				list.add(nums[i]);
			} else {
				temp[nums[i]] = 1;
			}
		}

		return list;
	}

	public List<Integer> findDuplicates2(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = (nums[i] < 0 ? nums[i] * -1 : nums[i]) - 1;
			if (nums[index] < 0) {
				list.add((nums[i] < 0 ? nums[i] * -1 : nums[i]));
			} else {
				nums[index] = (nums[index] * -1);
			}
		}
		return list;
	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				list.add(Math.abs(nums[i]));
			} else {
				nums[index] *= -1;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 7, 8, 9, 4, 6, 3 };

		System.out.println(findDuplicate1(arr));
	}

}
