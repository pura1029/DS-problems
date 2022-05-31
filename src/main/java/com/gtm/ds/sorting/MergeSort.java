package com.gtm.ds.sorting;

import java.util.Arrays;

public class MergeSort {

    static int[] sort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }


        int mid = arr.length / 2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }


    private static int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ans[k++] = left[i];
                i++;
            } else {
                ans[k++] = right[j];
                j++;
            }
        }

        while (i < left.length) {
            ans[k++] = left[i];
            i++;
        }

        while (j < right.length) {
            ans[k++] = right[j];
            j++;
        }

        return ans;
    }

    static void sortInPlace(int[] arr, int start, int end) {

        if (end - start == 1) {
            return;
        }


        int mid = (start + end) / 2;

        sortInPlace(arr, start, mid);
        sortInPlace(arr, mid, end);

        mergeInPlace(arr, mid, start, end);
    }


    private static void mergeInPlace(int[] arr, int mid, int start, int end) {
        int[] ans = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                ans[k++] = arr[i];
                i++;
            } else {
                ans[k++] = arr[j];
                j++;
            }
        }

        while (i < mid) {
            ans[k++] = arr[i];
            i++;
        }

        while (j < end) {
            ans[k++] = arr[j];
            j++;
        }

        //replace original arr with sorted arr
        //arr[start+l] means arr[3+0]=ans[0];
        for (int l = 0; l < ans.length; l++) {
            arr[start + l] = ans[l];
        }
    }


    public static void main(String[] args) {

        int[] arr = { 3, 1, 4, 5, 2 };
        sortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
