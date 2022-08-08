package com.gtm.ds.arr2d;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/
//find the maximum number of intervals that are non-overlapping.
public class MaximumNumberNonOverlapping {

	public static int eraseOverlapIntervals(int[][] intervals) {
	        if (intervals == null || intervals.length == 0) return 0;
	        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	        int prevEnd = intervals[0][1];
	        int count = 0;
	        for (int i = 1; i < intervals.length; i++) {
	            if (prevEnd > intervals[i][0]) {
	                count++;
	                prevEnd = Math.min(intervals[i][1], prevEnd);
	            } else {
	                prevEnd = intervals[i][1];
	            }
	        }
	        return count;
	    }
	
	public static void main(String[] args) {
		int [][] intervals = {{1,2},{1,3},{6,9},{5,8}};

		System.out.println(eraseOverlapIntervals(intervals));
	}

}
