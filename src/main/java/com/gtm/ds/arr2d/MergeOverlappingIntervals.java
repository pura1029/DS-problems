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

        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

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

    //https://www.geeksforgeeks.org/merging-intervals/
    public static void mergeIntervals1(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return;

        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            // if intervals overlapping then Merge previous and current Intervals
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        // Now arr[0..index-1] stores the merged Intervals
        System.out.println();
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++) {
            System.out.print("[" + intervals[i][0] + ","
                    + intervals[i][1] + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] intervals = {{7, 9}, {1, 6}, {2, 10}, {10, 15}};
        // {{ 1, 6 },{ 2, 8 },{ 7, 9 },{ 10, 15 }}

        mergeIntervals(intervals);
        mergeIntervals1(intervals);
    }

}
