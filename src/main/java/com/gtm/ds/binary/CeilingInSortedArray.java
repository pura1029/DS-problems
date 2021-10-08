package com.gtm.ds.binary;

public class CeilingInSortedArray {

    static int ceilSearch1(int arr[], int low, int high, int x) {
        int i;

        if (x <= arr[low])
            return low;

        for (i = low; i < high; i++) {
            if (arr[i] == x)
                return i;

            if (arr[i] < x && arr[i + 1] >= x)
                return i + 1;
        }

        return -1;
    }

    static int ceilSearch(int arr[], int low, int high, int x) {
        int mid;
        if (x <= arr[low]) {
            return low;
        }

        if (x > arr[high])
            return -1;

        mid = (low + high) / 2;

        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            if (mid + 1 <= high && x <= arr[mid + 1])
                return mid + 1;
            else
                return ceilSearch(arr, mid + 1, high, x);
        } else {
            if (mid - 1 >= low && x > arr[mid - 1])
                return mid;
            else
                return ceilSearch(arr, low, mid - 1, x);
        }

    }

    // return the index of smallest no >= target
    static int ceiling(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return start;
    }

    // return the char of smallest letter >= target
    static char nextGreatestLetter(char[] letters, char target) {
        if (target > letters[letters.length - 1]) {
            return letters[0];
        }

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
        int n = arr.length;
        int x = 11;
        int index = ceilSearch(arr, 0, n - 1, x);
        if (index == -1)
            System.out.println("Ceiling of " + x + " doesn't exist in array");
        else
            System.out.println("ceiling of " + x + " is " + arr[index]);

        index = ceiling(arr, x);
        if (index == -1)
            System.out.println("Ceiling1 of " + x + " doesn't exist in array");
        else
            System.out.println("ceiling1 of " + x + " is " + arr[index]);

    }

}
