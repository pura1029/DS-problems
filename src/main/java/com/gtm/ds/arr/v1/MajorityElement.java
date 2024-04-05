/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.arr.v1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element/description/
 *
 * @author kumargautam
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int n = nums[0];
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > len/2) {
                n=nums[i];
                break;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,3};//3
        int [] nums1 = {2,2,1,1,1,2,2};//2
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums1));
    }
}
