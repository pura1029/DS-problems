package com.gtm.ds.arr;

import java.util.HashMap;

//https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
public class CountDistinctWindow {
    static void countDistinct(int arr[], int K) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM
                = new HashMap<>();

        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < K; i++) {
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
        }

        // Print count of first window
        System.out.println(hM.size());

        // Traverse through the remaining array
        for (int i = K; i < arr.length; i++) {

            // Remove first element of previous window
            // If there was only one occurrence
            if (hM.get(arr[i - K]) == 1) {
                hM.remove(arr[i - K]);
            } else { // reduce count of the removed element
                hM.put(arr[i - K], hM.get(arr[i - K]) - 1);
            }

            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

            // Print count of current window
            System.out.println(hM.size());
        }
    }

    // Driver's code
    public static void main(String arg[]) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int K = 4;

        // Function call
        countDistinct(arr, K);
    }
}
