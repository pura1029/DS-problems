package com.gtm.ds.arr;

import java.util.ArrayList;
import java.util.List;

public class Median2SortedArr {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> mList = new ArrayList<>();

		int n = nums1.length;
		int m = nums2.length;

		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (nums1[i] < nums2[j]) {
				mList.add(nums1[i]);
				i++;
			} else {
				mList.add(nums2[j]);
				j++;
			}
		}

		while (i < n) {
			mList.add(nums1[i]);
			i++;
		}

		while (j < m) {
			mList.add(nums2[j]);
			j++;
		}

		int l = mList.size();
		int mid = l / 2;
		if (l % 2 == 0) {
			return (mList.get(mid) + mList.get(mid - 1)) / 2.0;
		}
		return mList.get(mid);

	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };

		Median2SortedArr sortedArr = new Median2SortedArr();

		System.out.println(sortedArr.findMedianSortedArrays(nums1, nums2));
	}

}
