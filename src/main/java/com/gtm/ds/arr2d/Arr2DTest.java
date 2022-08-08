package com.gtm.ds.arr2d;

import java.util.Arrays;

public class Arr2DTest {
	
	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+",");
			}
			System.out.print("]");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };

		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[0]);
		System.out.println(arr[0][1]);

		print(arr);

		Arrays.sort(arr, (a, b) -> a[1] - b[1]);
		
		print(arr);
	}

}
