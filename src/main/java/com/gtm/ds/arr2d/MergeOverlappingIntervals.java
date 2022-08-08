package com.gtm.ds.arr2d;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void mergeIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return;

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		Stack<Interval> stack = new Stack<>();

		stack.push(new Interval(intervals[0][0], intervals[0][1]));

		for (int i = 1; i < intervals.length; i++) {
			// get interval from stack top
			Interval top = stack.peek();

			// if current interval is not overlapping with stack top,
			// push it to the stack
			if (top.end < intervals[i][0]) {
				stack.push(new Interval(intervals[i][0], intervals[i][1]));
			}

			// Otherwise update the ending time of top if ending of current
			// interval is more
			else if (top.end < intervals[i][1]) {
				top.end = intervals[i][1];
				stack.pop();
				stack.push(top);
			}
		}

		// Print contents of stack
		System.out.print("The Merged Intervals are: ");
		while (!stack.isEmpty()) {
			Interval t = stack.pop();
			System.out.print("[" + t.start + "," + t.end + "] ");
		}
	}

	public static void main(String[] args) {
		int[][] intervals = { { 7, 9 }, { 1, 6 }, { 2, 8 }, { 10, 15 } };
		// {{ 1, 6 },{ 2, 8 },{ 7, 9 },{ 10, 15 }}

		mergeIntervals(intervals);
	}

}
