package com.gtm.ds.binary;

//https://www.geeksforgeeks.org/allocate-minimum-number-pages/
public class AllocateMinimumNumberPages {

	static int minPages(int[] a, int k) {

		int start = max(a);
		int end = sum(a);
		int res = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (isFeasible(a, k, mid)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	private static boolean isFeasible(int[] a, int k, int res) {
		int stu = 1;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (sum + a[i] > res) {
				stu++;
				sum = a[i];
			} else {
				sum += a[i];
			}
		}
		return (stu <= k);
	}

	private static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	private static int max(int[] a) {
		int max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = { 10, 5, 20, 3, 15, 4, 6 };
		int k = 3;
		System.out.println(minPages(a, k));

	}

}
