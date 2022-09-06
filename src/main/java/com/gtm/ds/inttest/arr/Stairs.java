package com.gtm.ds.inttest.arr;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
public class Stairs {

	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	static int countWays(int s) {
		return fib(s + 1);
	}

	static int countWays(int n, int[] s) {
		int count = 0;

		Set<Integer> preSum = new HashSet<>();

		for (int step : s) {
			int sub = n - step;

			if (preSum.contains(sub)) {
				count += 2;
			}

			count += setSteps(step, n, preSum);
		}

		return count;
	}

	private static int setSteps(int step, int n, Set<Integer> preSum) {
		int sum = 0;
		while (true) {
			sum += step;
			if (sum == n) {
				return 1;
			} else if (sum > n) {
				return 0;
			}
			preSum.add(sum);
		}
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int s = 4;
		System.out.println("Number of ways = " + countWays(s));

		int n = 6;
		int[] steps = { 1, 3, 4 };

		System.out.println("Number of ways = " + countWays(n, steps));
	}
}