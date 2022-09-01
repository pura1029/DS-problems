package com.gtm.ds.inttest;

public class FindSumWithUsingPlusOperator {

	public static int sum(int x, int y) {
		while (y != 0) {

			int carry = x & y;

			x = x ^ y;

			y = carry << 1;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(98, 12));

	}

}
