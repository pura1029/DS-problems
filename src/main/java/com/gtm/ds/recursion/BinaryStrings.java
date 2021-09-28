package com.gtm.ds.recursion;

import java.util.Arrays;

public class BinaryStrings {

    int arr[];

    public BinaryStrings(int n) {
        arr = new int[n];
    }

    public void binary(int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(arr));
        } else {
            arr[n - 1] = 0;
            binary(n - 1);
            arr[n - 1] = 1;
            binary(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        BinaryStrings binaryStrings = new BinaryStrings(n);
        binaryStrings.binary(n);

    }

}
