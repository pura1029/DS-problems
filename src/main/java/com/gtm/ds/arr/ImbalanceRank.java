package com.gtm.ds.arr;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/discuss/interview-question/1741735/amazon-hackerrank-oa-sde-2-february-2022
//https://www.geeksforgeeks.org/amazon-interview-experience-for-sde-ii-2/
public class ImbalanceRank {

	public static long imbalance(List<Integer> rank) {
		long imbalance = 0;
		int r = 0;
		TreeSet<Integer> set = new TreeSet<>();
		while (r < rank.size() - 1) {
			set.clear();
			set.add(rank.get(r));
			long curImbalance = 0;
			for (int i = r + 1; i < rank.size(); i++) {
				Integer e = rank.get(i);
				set.add(e);
				Integer f = set.lower(e);
				Integer c = set.higher(e);

				if (f == null) { // added at beginning
					curImbalance += (((c - e) > 1) ? 1 : 0);
				} else if (c == null) {// added at end
					curImbalance += (((e - f) > 1) ? 1 : 0);
				} else {
					curImbalance += (c - f) > 1 ? -1 : 0;
					curImbalance += (((c - e) > 1) ? 1 : 0);
					curImbalance += (((e - f) > 1) ? 1 : 0);
				}
				imbalance += curImbalance;
			}
			r++;
		}
		return imbalance;
	}

	/**
	 * This is the example that was given : [4,1,3,2] [1] contributes 0 to imbalance
	 * [2] contributes 0 to imbalance [3] contributes 0 to imbalance [4] contributes
	 * 0 to imbalance [4,1] contributes 1 to imbalance [4,3] contributes 0 to
	 * imbalance [4,2] contributes 1 to imbalance [4,1,3,2] contributes 0 to
	 * imbalance [1,3] contributes 1 to imbalance [1,2] contributes 0 to imbalance
	 * [3,2] contributes 0 to imbalance Answer = 1 + 1 + 1 = 3
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> rank = new ArrayList<>();
		rank.add(4);
		rank.add(1);
		rank.add(3);
		rank.add(2);

		System.out.println(imbalance(rank));
	}
}
