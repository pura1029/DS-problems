package com.gtm.ds.binary;

//Find the position of an element in a sorted infinite array
public class InfiniteArray {

    static int search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            if (arr[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    static int findPos(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, 7, 9, 10, 12, 15, 16, 18, 20, 24, 28, 32, 35 };
        int target = 16;
        System.out.println("Index :"+findPos(arr, target));
    }

}
