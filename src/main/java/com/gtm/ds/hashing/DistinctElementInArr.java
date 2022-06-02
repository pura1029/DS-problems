package com.gtm.ds.hashing;

import java.util.HashSet;
import java.util.Set;

public class DistinctElementInArr {

	static int count(int[] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int cont = 0;
			for (int j = i; j >= 0; j--) {
				if (arr[i] == arr[j]) {
					cont++;
				}
				if (cont > 1) {
					break;
				}
			}
			if (cont == 1) {
				res++;
			}
		}
		return res;
	}

	static int countHash(int[] arr) {
		Set<Integer> hashInt = new HashSet<>();
		for (int a : arr) {
			hashInt.add(a);
		}
		return hashInt.size();
	}

	public static void main(String[] args) {
		int[] arr = { 5, 10, 15, 5, 4, 5, 4, 15 };
		System.out.println(countHash(arr));

	}

}
