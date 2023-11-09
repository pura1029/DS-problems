/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.two_pointers;

/**
 * Insert your comment for {@link KDiffPairs}.
 *
 * @author kumargautam
 */

//https://workat.tech/problem-solving/practice/k-diff-pairs
public class KDiffPairs {

    static int kDiffPairs(int[] A, int k) {
        int count = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            int lo = i;
            int hi = n - 1;
            while (lo < hi) {
                int diff = A[hi] - A[lo];
                if (diff == k) {
                    count++;
                    lo++;
                    hi--;
                } else if (diff < k) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }

    static int kDiffPairs1(int[] A, int k) {
        int count = 0;
        int n = A.length;
        int lo = 0;
        int hi = 1;
        while (hi < n) {
            //skip duplicate
            while (hi < (n - 1) && A[hi] == A[hi + 1]) {
                hi++;
            }
            int diff = A[hi] - A[lo];
            if (diff == k) {
                count++;
                lo++;
                hi++;
            } else if (diff < k) {
                hi++;
            } else {//(diff > k)
                lo++;
            }
            if (lo == hi) {
                hi++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 7, 10};
        int k = 2;
        System.out.println(kDiffPairs(A, k));
        System.out.println(kDiffPairs1(A, k));
    }
}
