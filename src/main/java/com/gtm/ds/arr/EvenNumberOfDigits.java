package com.gtm.ds.arr;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenNumberOfDigits {

	public int findNumbers(int[] nums) {
		int count = 0;
		for (int num : nums) {
			if (even(num)) {
				count++;
			}
		}
		return count;
	}

	private boolean even(int num) {
		int noOfDigits = digits(num);
		return (noOfDigits % 2 == 0);
	}

	private int digits2(int num) {
		if (num < 0) {
			num = num * -1;
		}
		return (int) Math.log10(num) + 1;
	}

	private int digits(int num) {
		if (num < 0) {
			num = num * -1;
		}

		if (num == 0) {
			return 1;
		}

		int count = 0;
		while (num > 0) {
			count++;
			num = num / 10;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 555, 901, 482, 1771 };
		System.out.println(new EvenNumberOfDigits().findNumbers(nums));
	}

}
