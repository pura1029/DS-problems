package com.gtm.ds.arr;

//https://practice.geeksforgeeks.org/problems/wine-buying-and-selling/1
public class WineSelling {

	/**
	 * if a[i] < 0, then ith house wants to sell a[i] number of a wine bottle to
	 * other houses. if a[i] > 0, then ith house wants to buy a[i] number of a wine
	 * bottle from other houses.
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	static int wineSelling(int[] arr, int n) {
		int b = 0;
		int s = 0;
		int sum = 0;
		while (b < n && s < n) {
			while (arr[b] <= 0) {

				b++;

				if (b == n) {
					return sum;
				}
			}

			while (arr[s] >= 0) {
				s++;

				if (s == n) {
					return sum;
				}
			}

			if (arr[b] >= Math.abs(arr[s])) {
				sum += Math.abs(b - s) * Math.abs(arr[s]);

				arr[b] += arr[s];

				arr[s] = 0;
			} else {
				sum += Math.abs(b - s) * arr[b];

				arr[s] += arr[b];

				arr[b] = 0;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 5, -4, 1, -3, 1 };
		System.out.println(wineSelling(arr, arr.length));
	}
}