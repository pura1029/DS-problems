package com.gtm.ds.binary;

/**
 * 
 * @see https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 *
 * @author kumargautam
 */
public class RotatedSortedArr {

    static int rotationCount(int[] nums) {
        int pivot = pivotIndex(nums);
        return pivot + 1;
    }

    static int pivotIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int pivotIndexForDuplicateElements(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            //skip duplicate elements
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                //check start and end were pivot?

                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("No of rotation : " + rotationCount(nums));
    }

}
