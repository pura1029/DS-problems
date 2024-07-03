The Merge Intervals technique is commonly used to combine overlapping intervals into a single interval. Here's a step-by-step guide on how to implement this technique in Java:

1. **Sort the Intervals**: First, sort the intervals based on the starting point.
2. **Merge Overlapping Intervals**: Iterate through the sorted intervals and merge overlapping ones.

Here's the Java code to achieve this:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }

        // Sort intervals based on the starting point
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);

            if (currentInterval.end >= nextInterval.start) {
                // Overlapping intervals, merge them
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                // Non-overlapping interval, add the current interval to the list and move to the next
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        List<Interval> mergedIntervals = merge(intervals);

        for (Interval interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}
```

### Explanation:

1. **Interval Class**:
    - Represents an interval with a start and end point.
    - The `toString` method is overridden to display intervals in a readable format.

2. **merge Method**:
    - Sorts the list of intervals based on the starting point.
    - Iterates through the sorted intervals to merge overlapping ones.
    - Adds the merged intervals to a new list.

3. **main Method**:
    - Creates a list of intervals.
    - Calls the `merge` method to merge overlapping intervals.
    - Prints the merged intervals.

### Usage:
You can run this code in any Java environment. It will print the merged intervals, demonstrating the Merge Intervals technique.

Here is a list of common problems that can be solved using the Merge Intervals technique along with their solutions:

### 1. Merge Intervals
**Problem:** Given a collection of intervals, merge all overlapping intervals.

**Solution:**

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);
            if (currentInterval.end >= nextInterval.start) {
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        List<Interval> mergedIntervals = merge(intervals);
        for (Interval interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}
```

### 2. Insert Interval
**Problem:** Given a set of non-overlapping intervals and a new interval, insert the new interval into the intervals (merge if necessary).

**Solution:**

```java
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;

        // Add all intervals before the new interval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);

        // Add all intervals after the new interval
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(6, 9)
        );
        Interval newInterval = new Interval(2, 5);

        List<Interval> mergedIntervals = insert(intervals, newInterval);
        for (Interval interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}
```

### 3. Meeting Rooms II
**Problem:** Given an array of meeting time intervals, return the minimum number of conference rooms required.

**Solution:**

```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i].end);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };

        System.out.println(minMeetingRooms(intervals));
    }
}
```

### 4. Employee Free Time
**Problem:** Given a list of schedule where `schedule[i]` is a list of intervals representing the working time for the i-th employee, return the list of finite intervals representing common free time for all employees.

**Solution:**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeInterval {
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}

public class EmployeeFreeTime {

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.interval.start, b.interval.start));

        for (int i = 0; i < schedule.size(); i++) {
            minHeap.add(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();

            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else {
                if (previousInterval.end < queueTop.interval.end) {
                    previousInterval = queueTop.interval;
                }
            }

            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (queueTop.intervalIndex + 1 < employeeSchedule.size()) {
                minHeap.add(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1), queueTop.employeeIndex, queueTop.intervalIndex + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        schedule.add(Arrays.asList(new Interval(2, 4)));
        schedule.add(Arrays.asList(new Interval(2, 5), new Interval(9, 12)));

        List<Interval> freeTime = employeeFreeTime(schedule);
        for (Interval interval : freeTime) {
            System.out.println(interval);
        }
    }
}
```

These examples cover a range of problems that can be solved using the Merge Intervals technique, showcasing the versatility and importance of understanding this approach.

Sure! Here are additional questions along with their solutions using the Merge Intervals technique:

### 5. Interval List Intersections
**Problem:** Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order. Return the intersection of these two interval lists.

**Solution:**

```java
import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public static Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> intersections = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i].start, B[j].start);
            int end = Math.min(A[i].end, B[j].end);

            if (start <= end) {
                intersections.add(new Interval(start, end));
            }

            if (A[i].end < B[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return intersections.toArray(new Interval[intersections.size()]);
    }

    public static void main(String[] args) {
        Interval[] A = {
                new Interval(0, 2),
                new Interval(5, 10),
                new Interval(13, 23),
                new Interval(24, 25)
        };

        Interval[] B = {
                new Interval(1, 5),
                new Interval(8, 12),
                new Interval(15, 24),
                new Interval(25, 26)
        };

        Interval[] result = intervalIntersection(A, B);
        for (Interval interval : result) {
            System.out.println(interval);
        }
    }
}
```

### 6. Non-overlapping Intervals
**Problem:** Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

**Solution:**

```java
import java.util.Arrays;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
        int count = 0;
        int end = intervals[0].end;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) {
                count++;
            } else {
                end = intervals[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(1, 3)
        };

        System.out.println(eraseOverlapIntervals(intervals)); // Output: 1
    }
}
```

### 7. Minimum Number of Arrows to Burst Balloons
**Problem:** Given a collection of balloons, represented as a 2D integer array where intervals[i] = [start, end], return the minimum number of arrows that must be shot to burst all balloons.

**Solution:**

```java
import java.util.Arrays;

public class MinArrowsBurstBalloons {

    public static int findMinArrowShots(Interval[] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a.end, b.end));
        int arrows = 1;
        int end = points[0].end;

        for (int i = 1; i < points.length; i++) {
            if (points[i].start > end) {
                arrows++;
                end = points[i].end;
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Interval[] points = {
                new Interval(10, 16),
                new Interval(2, 8),
                new Interval(1, 6),
                new Interval(7, 12)
        };

        System.out.println(findMinArrowShots(points)); // Output: 2
    }
}
```

### 8. Can Attend All Meetings
**Problem:** Given an array of meeting time intervals where intervals[i] = [start, end], determine if a person could attend all meetings.

**Solution:**

```java
import java.util.Arrays;

public class CanAttendMeetings {

    public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };

        System.out.println(canAttendMeetings(intervals)); // Output: false
    }
}
```

### 9. Merge Intervals in a Binary Search Tree
**Problem:** Given a binary search tree where each node represents an interval, merge all overlapping intervals and return the merged intervals as a list.

**Solution:**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    Interval interval;
    TreeNode left, right;

    TreeNode(Interval interval) {
        this.interval = interval;
    }
}

public class MergeIntervalsBST {

    public static List<Interval> mergeIntervals(TreeNode root) {
        List<Interval> intervals = new ArrayList<>();
        inOrderTraversal(root, intervals);
        return merge(intervals);
    }

    private static void inOrderTraversal(TreeNode node, List<Interval> intervals) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, intervals);
        intervals.add(node.interval);
        inOrderTraversal(node.right, intervals);
    }

    private static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);
            if (currentInterval.end >= nextInterval.start) {
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Interval(1, 3));
        root.left = new TreeNode(new Interval(2, 6));
        root.right = new TreeNode(new Interval(8, 10));
        root.left.left = new TreeNode(new Interval(15, 18));

        List<Interval> mergedIntervals = mergeIntervals(root);
        for (Interval interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}
```

These problems provide a variety of applications of the Merge Intervals technique, demonstrating its utility in different scenarios.

Certainly! Here are additional questions along with their solutions using the Merge Intervals technique:

### 10. Merge k Sorted Interval Lists
**Problem:** Given `k` sorted interval lists, merge them into a single sorted interval list.

**Solution:**

```java
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedIntervalLists {

    public static List<Interval> mergeKLists(List<List<Interval>> intervals) {
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));
        for (List<Interval> intervalList : intervals) {
            minHeap.addAll(intervalList);
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = minHeap.poll();

        while (!minHeap.isEmpty()) {
            Interval nextInterval = minHeap.poll();
            if (currentInterval.end >= nextInterval.start) {
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        if (currentInterval != null) {
            mergedIntervals.add(currentInterval);
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> list1 = Arrays.asList(new Interval(1, 3), new Interval(5, 7));
        List<Interval> list2 = Arrays.asList(new Interval(2, 6), new Interval(8, 10));
        List<Interval> list3 = Arrays.asList(new Interval(4, 5), new Interval(9, 11));

        List<List<Interval>> intervals = Arrays.asList(list1, list2, list3);

        List<Interval> mergedIntervals = mergeKLists(intervals);
        for (Interval interval : mergedIntervals) {
            System.out.println(interval);
        }
    }
}
```

### 11. Maximum Number of Events That Can Be Attended
**Problem:** Given an array of events where `events[i] = [startDayi, endDayi]`, return the maximum number of non-overlapping events that can be attended.

**Solution:**

```java
import java.util.Arrays;

public class MaxEvents {

    public static int maxEvents(Interval[] events) {
        Arrays.sort(events, (a, b) -> a.end - b.end);
        boolean[] attended = new boolean[100001];  // Assumes events end within this range

        int count = 0;
        for (Interval event : events) {
            for (int day = event.start; day <= event.end; day++) {
                if (!attended[day]) {
                    attended[day] = true;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Interval[] events = {
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(1, 2)
        };

        System.out.println(maxEvents(events));  // Output: 4
    }
}
```

### 12. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
**Problem:** Given an array of integers `nums` and an integer `limit`, return the size of the longest continuous subarray such that the absolute difference between any two elements is less than or equal to `limit`.

**Solution:**

```java
import java.util.TreeMap;

public class LongestSubarray {

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;

        for (right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }

        return right - left;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;

        System.out.println(longestSubarray(nums, limit));  // Output: 2
    }
}
```

### 13. Find Right Interval
**Problem:** Given a list of intervals, for each interval `i`, find the index of the smallest interval `j` such that `interval i` does not overlap with `interval j`.

**Solution:**

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {

    public static int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        Map<Interval, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        Interval[] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> a.start - b.start);

        for (int i = 0; i < intervals.length; i++) {
            int index = binarySearch(sorted, intervals[i].end);
            result[i] = index == -1 ? -1 : map.get(sorted[index]);
        }

        return result;
    }

    private static int binarySearch(Interval[] intervals, int target) {
        int left = 0, right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid].start >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < intervals.length ? left : -1;
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(0, 1)
        };

        int[] result = findRightInterval(intervals);
        System.out.println(Arrays.toString(result));  // Output: [1, -1, 0]
    }
}
```

### 14. Minimum Interval to Include Each Query
**Problem:** Given an array of intervals and an array of queries, for each query, find the minimum interval size that includes the query.

**Solution:**

```java
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinIntervalToIncludeEachQuery {

    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        int i = 0;

        for (int[] query : sortedQueries) {
            int q = query[0];
            while (i < intervals.length && intervals[i][0] <= q) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                if (end >= q) {
                    minHeap.offer(new int[]{end - start + 1, end});
                }
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                result[query[1]] = minHeap.peek()[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}};
        int[] queries = {2, 3, 4, 5};

        int[] result = minInterval(intervals, queries);
        System.out.println(Arrays.toString(result));  // Output: [3, 3, 3, 4]
    }
}
```

### 15. Remove Covered Intervals
**Problem:** Given a list of intervals, remove all intervals that are covered by another interval in the list.

**Solution:**

```java
import java.util.Arrays;

public class RemoveCoveredIntervals {

    public static int removeCoveredIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? b.end - a.end : a.start - b.start);

        int count = 0, end = 0;
        for (Interval interval : intervals) {
            if (interval.end > end) {
                count++;
                end = interval.end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 4),
                new Interval(3, 6),
                new Interval(2, 8)
        };

        System.out.println(removeCoveredIntervals(intervals));  // Output: 2
    }
}
```

These problems showcase various ways in which the Merge Intervals technique can be applied to solve different types of interval-related questions, 
highlighting its versatility and importance in algorithm design.

