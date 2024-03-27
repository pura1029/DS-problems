package com.gtm.ds.arr;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//https://www.geeksforgeeks.org/longest-sub-array-sum-k/
public class LongSubArr {

// function to find the length of longest

// subarray having sum k

    static int lenOfLongSubarr(int A[], int N, int K) {

        int i = 0, j = 0, sum = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < N) {
            sum += A[j];
            if (sum < K) {
                j++;
            } else if (sum == K) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;

            } else if (sum > K) {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }

                if (sum == K) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                j++;

            }

        }

        return maxLen;

    }


    // function to find the length of longest
    // subarray having sum k

    static int lenOfLongSubarr1(int[] arr, int n, int k) {

        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {


            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k) {
                maxLen = i + 1;
            }

            // make an entry for 'sum' if it is

            // not present in 'map'

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }


            // check if 'sum-k' is present in 'map'

            // or not

            if (map.containsKey(sum - k)) {
                // update maxLength

                if (maxLen < (i - map.get(sum - k))) {
                    maxLen = i - map.get(sum - k);
                }
            }

        }

        return maxLen;

    }


    // Driver code

    public static void main(String args[]) {

        int arr[] = {10, 5, 2, 7, 1, 9};

        int n = arr.length;

        int k = 15;

        System.out.printf("Length = %d\n", lenOfLongSubarr(arr, n, k));
        Integer[] arr1 = Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(a -> (int) a).reversed()).toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr1));

    }


}
