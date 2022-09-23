package com.gtm.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
public class DistinctElementInArrWithWindow {

	public static List<Integer> countDistinct(int[] arr, int n, int k) {
		// code here
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		// first window
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		res.add(map.size());

		for (int i = k; i < n; i++) {
			int t = arr[i - k];
			int temp = map.get(t);
			if (temp == 1) {
				map.remove(t);
			} else {
				map.put(t, temp - 1);
			}

			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

			res.add(map.size());
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		System.out.println(countDistinct(arr, arr.length, k));
	}
}
