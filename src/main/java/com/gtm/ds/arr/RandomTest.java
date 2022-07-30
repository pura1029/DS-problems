package com.gtm.ds.arr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {

	static int customRandomNum(int[] arr) {

		List<Integer> randomList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int ele = arr[i];
			int j = 0;
			while (j < ele) {
				randomList.add(ele);
				j++;
			}
		}

		Random random = new Random();
		int r = random.nextInt((randomList.size()));

		return randomList.get(r);
	}

	static int customRandomNum1(int[] arr) {
		int sum = getSum(arr);
		Random random = new Random();
		int r = random.nextInt((sum+1));

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += arr[i];
			if (r <= count) {
				return arr[i];
			}
		}
		return -1;
	}

	private static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 1 };
		System.out.println(customRandomNum1(arr));
	}

}
