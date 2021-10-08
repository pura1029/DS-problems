package com.gtm.ds.arr;

import java.util.Arrays;

public class MoveZeros {

    void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12, 0 };
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
