package com.gtm.ds.binary;

import java.util.Arrays;

public class FirstAndLastPositionSA {

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (target != nums[i])
                continue;
            if (first == -1)
                first = i;
            last = i;
        }
        return new int[] { first, last };
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // find the middle element
            //            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println("Result " + Arrays.toString(res));

        res = new FirstAndLastPositionSA().searchRange1(nums, target);
        System.out.println("Result " + Arrays.toString(res));
    }

}
