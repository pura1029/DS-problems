package com.gtm.ds.arr;

public class SortedBinaryArrayCountOnes {
    public static int countOnes(int[] nums) {
        int low = 0, high = nums.length - 1;

        // Perform binary search to find the first occurrence of 1
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == 0) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == 0) { // Check if mid is the first occurrence of 1
                    return nums.length - mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        // If no 1 is found, return 0
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 1};
        //int[] nums = {1, 1, 1, 1, 1, 1, 1};
        System.out.println("Number of 1s: " + countOnes(nums)); // Output: 5
    }
}
