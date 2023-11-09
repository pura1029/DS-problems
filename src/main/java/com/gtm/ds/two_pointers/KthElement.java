/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.two_pointers;

/**
 * Insert your comment for {@link KthElement}.
 *
 * @author kumargautam
 */
//https://workat.tech/problem-solving/practice/kth-two-sorted
public class KthElement {

    static int getKthElement(int[] firstArr, int[] secondArr, int k) {
        // add logic here
        int n1 = firstArr.length;
        int n2 = secondArr.length;
        int ele = -1;
        if (n1 + n2 < k) {
            return ele;
        }

        int i = 0;
        int j = 0;
        int r = 0;
        while (i < n1 && j < n2) {
            if (firstArr[i] < secondArr[j]) {
                ele = firstArr[i];
                r++;
                i++;
            } else {
                ele = secondArr[j];
                r++;
                j++;
            }
            if (r == k) {
                return ele;
            }
        }

        while (i < n1) {
            ele = firstArr[i];
            r++;
            i++;
            if (r == k) {
                return ele;
            }
        }
        while (j < n2) {
            ele = secondArr[j];
            r++;
            j++;
            if (r == k) {
                return ele;
            }
        }
        return ele;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6};
        int[] a2 = {3, 4, 4, 5, 6, 6};
        int k = 6;
        System.out.println(getKthElement(a1, a2, k));
    }
}
