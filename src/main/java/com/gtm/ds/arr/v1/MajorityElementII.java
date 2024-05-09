/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.arr.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/description/.
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * @author kumargautam
 */
public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Initializing candidates and their counts
        // there is probability, num arr have 2 major element.
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;

        // Phase 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;// candidate1 is current no
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;// candidate1 is current no
                count2 = 1;
            } else { // candidate1 or candidate2 is not same as current no
                count1--;
                count2--;
            }
        }

        // Phase 2: Count occurrences of potential candidates
        count1 = count2 = 0;
        for (int num : nums) {
            // count candidate1 and candidate2 in given num array
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
        int[] nums = {3, 1, 3, 3, 4, 4, 3, 4, 2, 4};
        int[] nums1 = {3};
        int[] nums2 = {1, 2};
        System.out.println(majorityElement(nums));
    }
}
