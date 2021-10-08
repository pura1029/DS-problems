package com.gtm.ds.binary;

import java.util.Arrays;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
//Rotated Binary search.
public class RotatedBinarySearch {

    static int[] roate(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;
        int k = 0;
        for (int i = d; i < n + d; i++) {
            if (i < n) {
                temp[j++] = arr[i];
            }
            if (i >= n) {
                temp[j++] = arr[k++];
            }
        }
        return temp;
    }

    public int search(int[] nums, int target) {
        int pivotIndex = pivotIndex(nums);
        if (pivotIndex == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivotIndex - 1);
        }
        return binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
    }

    int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    int pivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int pivotIndexForDuplicateElements(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            //skip duplicate elements
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                //check start and end were pivot?

                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int d = 6;
        System.out.println("Arr :" + Arrays.toString(roate(arr, d)));

        RotatedBinarySearch roateArr = new RotatedBinarySearch();
        int nums[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("pivotIndex :" + roateArr.pivotIndex(nums));
    }
}
