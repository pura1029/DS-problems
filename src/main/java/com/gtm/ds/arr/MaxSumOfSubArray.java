package com.gtm.ds.arr;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//Kadane’s Algorithm:
public class MaxSumOfSubArray {

    static int maxSum(int[] a) {
        int maxSum = a[0];
        int currSum = 0;
        for (int i = 0; i < a.length; i++) {
            currSum += a[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    static void maxSubArraySum(int a[]) {
        int size = a.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < size; i++) {
            sum += a[i];

            if (maxSum < sum) {
                maxSum = sum;
                end = i;
            }

            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + maxSum);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSum(a));
        maxSubArraySum(a);
    }

}
