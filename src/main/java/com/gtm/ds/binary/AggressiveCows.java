package com.gtm.ds.binary;

import java.util.Arrays;

//https://leetcode.com/discuss/general-discussion/1302335/aggressive-cows-spoj-fully-explained-c
public class AggressiveCows {

	public static int aggressiveCows(int[] stalls, int cows) {
		Arrays.sort(stalls);
		int n = stalls.length;
		int low = 1;
		int hi = stalls[n - 1] - stalls[0];
		int res = 0;
		while (low <= hi) {
			int mid = (low + hi) >> 1;
			if (isPossible(mid, stalls, cows)) {
				res = mid;
				low = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		return res;
	}

	public static int aggressiveCows1(int[] stalls, int cows) {
		Arrays.sort(stalls);
		int larDist = 0;
		for (int dis = stalls[0]; dis <= stalls[stalls.length - 1]; dis++) {
			if (isPossible(dis, stalls, cows)) {
				if (larDist < dis) {
					larDist = dis;
				}
			}
		}
		return larDist;
	}

	private static boolean isPossible(int minDist, int[] stalls, int cows) {
		int cowCount = 1;
		int lastCowPosition = stalls[0];

		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - lastCowPosition >= minDist) {
				cowCount++;
				lastCowPosition = stalls[i];
				if (cowCount >= cows)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] stalls = { 1, 2, 4, 8, 9 };
		int cows = 3;
		System.out.println(aggressiveCows(stalls, cows));
	}

}
