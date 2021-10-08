package com.gtm.ds.arr;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
public class TripletsWithZeroSum {

    // function to print triplets with 0 sum
    static void findTriplets(int arr[], int n) {
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "-arr[i]"
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false) {
            System.out.printf(" No Triplet Found\n");
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        findTriplets(arr, n);

    }

}
