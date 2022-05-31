package com.gtm.ds.binary;

public class BinarySearchForSortedAndRotatedArray {

	static int pivotIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}
			if (arr[mid] <= arr[start]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	static int search1(int[] arr, int target) {
		int pivotIndex = pivotIndex(arr);
		if (pivotIndex == -1) {
			return pivotIndex;
		}
		if (arr[pivotIndex] == target) {
			return pivotIndex;
		}
		if (target >= arr[0]) {
			return binarySearch(arr, target, 0, pivotIndex - 1);
		}
		return binarySearch(arr, target, pivotIndex + 1, arr.length - 1);
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
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

	static int search(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[start] < arr[mid]) {
				if (target >= arr[start] && target < arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target > arr[mid] && target <= arr[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 20, 30, 40, 50, 60, 5, 10 };
		int arr1[] = { 120, 130, 140, 40, 50, 90, 100, 110 };
		System.out.println(search1(arr1, 130));
	}

}
