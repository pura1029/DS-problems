package com.gtm.ds.sorting;

import java.util.Arrays;

public class DSSorting {

    /**
     * repeatedly swapping the adjacent elements if they are in wrong order.
     * 
     * @param arr
     */
    static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Select max element and move to last.
     * 
     * @param arr
     */
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    /**
     * The array is virtually split into a sorted and an unsorted part. Values from the unsorted
     * part are picked and placed at the correct position in the sorted part.
     * 
     * @param arr
     */
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 5, 2 };
        System.out.println("max :" + getMaxIndex(arr, 1, 3));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
