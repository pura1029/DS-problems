/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Insert your comment for {@link ThreeSum}.
 *
 * @author kumargautam
 */
//https://workat.tech/problem-solving/practice/three-sum
public class ThreeSum {

    static List<List<Integer>> threeSum(int[] A) {
        int n = A.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> resultList = new HashSet<>();
        Arrays.sort(A);
        for (int i = 0; i < n - 1; i++) {
            int lo = i + 1;
            int hi = n - 1;

            while (lo < hi) {
                int sum = A[i] + A[lo] + A[hi];
                if (sum == 0) {
                    List<Integer> subList = Arrays.asList(A[i], A[lo], A[hi]);
                    Collections.sort(subList);
                    resultList.add(subList);
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {// sum > 0
                    hi--;
                }
            }
        }
        return new ArrayList<>(resultList);
    }

    static List<List<Integer>> threeSum1(int[] A) {
        int n = A.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n - 1;
            //skip duplicate elements from start
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            while (lo < hi) {
                //skip duplicate elements from end
                if (hi < (n - 1) && A[hi] == A[hi + 1]) {
                    hi--;
                    continue;
                }
                int sum = A[i] + A[lo] + A[hi];
                if (sum == 0) {
                    List<Integer> subList = Arrays.asList(A[i], A[lo], A[hi]);
                    Collections.sort(subList);
                    resultList.add(subList);
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {// sum > 0
                    hi--;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 0, -1, -2};

        System.out.println(threeSum(A));
        System.out.println(threeSum1(A));
    }
}
