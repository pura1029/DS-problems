/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.arr.a1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/description/.
 *
 * @author kumargautam
 */
public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Initializing candidates and their counts
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;

        // Phase 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Count occurrences of potential candidates
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Check if candidates appear more than n/3 times
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int[] nums1 = {3};
        int[] nums2 = {1, 2};
        System.out.println(majorityElement(nums2));
    }
}
