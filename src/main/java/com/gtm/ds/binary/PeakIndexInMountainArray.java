package com.gtm.ds.binary;

public class PeakIndexInMountainArray {

    static int peak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] < arr[start + 1]) {
                start++;
            }
            if (arr[start] > arr[start + 1]) {
                return start;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    public static void main(String[] args) {

        int[] arr = new int[] { 0, 10, 5, 2 };
        System.out.println("Peak index :" + new PeakIndexInMountainArray().peakIndexInMountainArray(arr));
    }

}
