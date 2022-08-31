package com.gtm.ds.arr;

public class CountEqaulSuffixInArr {

	public int count(int a, int b, int[] arr) {
		int n = arr.length;
		int result = -1;
		if (n <= 1) {
			return result;
		}
		int aCount = 0;
		int bCount = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == a) {
				aCount++;
			} else if (arr[i] == b) {
				bCount++;
			}

			if (aCount != 0 && aCount == bCount) {
				result = i;
			} else if (result != -1) {
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		CountEqaulSuffixInArr eqaulSuffixInArr = new CountEqaulSuffixInArr();

		int[] arr = { 1, 3, 2, 4, 2, 5 };
		int a = 1;
		int b = 2;

		System.out.println(eqaulSuffixInArr.count(a, b, arr));
	}

}
