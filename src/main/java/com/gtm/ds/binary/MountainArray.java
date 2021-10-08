package com.gtm.ds.binary;

/**
 * 
 * See <a href="https://leetcode.com/problems/find-in-mountain-array/">MountainArray problem
 * desc</a>
 * 
 * @author kumargautam
 */
public class MountainArray {

    public int findInMountainArray(int[] arr, int target) {
        int peakIndex = peakIndexInMountainArray(arr);
        int pos = searchInOrder(arr, target, 0, peakIndex);
        if (pos == -1) {
            pos = searchInOrder(arr, target, peakIndex + 1, arr.length - 1);
        }
        return pos;
    }

    int peakIndexInMountainArray(int[] arr) {
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

    int searchInOrder(int[] arr, int target, int start, int end) {

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //[1,2,3,4,5,3,1]
        //3
        int[] arr = new int[] { 1, 5, 2 };
        int target = 2;
        System.out.println("Index :" + new MountainArray().findInMountainArray(arr, target));

    }

}
