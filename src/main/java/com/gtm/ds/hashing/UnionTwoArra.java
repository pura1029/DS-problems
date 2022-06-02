package com.gtm.ds.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionTwoArra {

	static int union(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);

		List<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				if (Collections.binarySearch(list, a[i], Comparator.naturalOrder()) < 0) {
					list.add(a[i]);
				}
				i++;
			} else {
				if (!list.contains(b[j])) {
					list.add(b[j]);
				}
				j++;
			}
		}
		if (i < a.length) {
			while (i < a.length) {
				if (!list.contains(a[i])) {
					list.add(a[i]);
				}
				i++;
			}
		}
		if (j < b.length) {
			while (j < b.length) {
				if (!list.contains(b[i])) {
					list.add(b[i]);
				}
				j++;
			}
		}
		System.out.println(list.toString());
		return list.size();
	}
	
	static int unionHashing(int[] arr, int[] brr) {
		Set<Integer> hashInt = new HashSet<>();
		for (int a : arr) {
			hashInt.add(a);
		}
		for (int a : brr) {
			hashInt.add(a);
		}
		System.out.println(hashInt.toString());
		return hashInt.size();
	}

	public static void main(String[] args) {
		int[] a = { 5, 10, 15, 5 };
		int[] b = { 10, 15, 4 };
		System.out.println(unionHashing(a, b));
	}

}
