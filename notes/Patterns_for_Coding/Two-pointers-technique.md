The Two Pointers technique is a common algorithmic strategy used to solve problems involving arrays or linked lists. It involves using two pointers (or indices) to traverse the data structure from different directions, often to find pairs of elements that satisfy certain conditions.

Here's a basic explanation and example in Java:

### Problem Example
Given a sorted array, find if there exists a pair of elements that sum up to a given target.

### Solution using Two Pointers

1. **Initialize Two Pointers**: One pointer at the beginning (`left`) and one at the end (`right`) of the array.
2. **Traverse the Array**:
    - Calculate the sum of the elements at the two pointers.
    - If the sum is equal to the target, return the indices or the pair.
    - If the sum is less than the target, move the `left` pointer to the right (increase the sum).
    - If the sum is greater than the target, move the `right` pointer to the left (decrease the sum).
3. **Continue until the pointers meet**.

### Java Code Example

```java
public class TwoPointersExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 8, 9};
        int target = 10;

        int[] result = findPairWithSum(array, target);

        if (result != null) {
            System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No pair found with the given target sum.");
        }
    }

    public static int[] findPairWithSum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int sum = array[left] + array[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null; // No pair found
    }
}
```

### Explanation

- **Initialization**: `left` starts at index 0, `right` starts at the last index.
- **Loop**: Continue the loop while `left` is less than `right`.
    - Calculate the sum of `array[left]` and `array[right]`.
    - If the sum is equal to the target, return the indices.
    - If the sum is less than the target, increment `left` to increase the sum.
    - If the sum is greater than the target, decrement `right` to decrease the sum.
- **Termination**: The loop terminates when `left` is no longer less than `right`.

This method efficiently finds the pair with a time complexity of O(n) because each element is visited at most once by either pointer.

Here is a list of common problems solved using the Two Pointers technique along with their solutions implemented in Java with proper class structures:

### 1. Two Sum II - Input Array is Sorted
**Problem**: Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number. Return the indices of the two numbers (1-based).

**Solution**:
```java
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // No solution
    }

    public static void main(String[] args) {
        TwoSumII solver = new TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
```

### 2. Remove Duplicates from Sorted Array
**Problem**: Given a sorted array `nums`, remove the duplicates in-place such that each element appears only once and returns the new length.

**Solution**:
```java
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates solver = new RemoveDuplicates();
        int[] nums = {1, 1, 2};
        int length = solver.removeDuplicates(nums);
        System.out.println("New length: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
```

### 3. Move Zeroes
**Problem**: Given an array `nums`, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

**Solution**:
```java
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solver = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        solver.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

### 4. Container With Most Water
**Problem**: Given `n` non-negative integers `a1, a2, ..., an`, where each represents a point at coordinate (i, ai). `n` vertical lines are drawn such that the two endpoints of the line `i` is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

**Solution**:
```java
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * currentHeight);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solver.maxArea(height);
        System.out.println("Max area: " + result);
    }
}
```

### 5. Sort Colors (Dutch National Flag Problem)
**Problem**: Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. Here, we use the integers `0`, `1`, and `2` to represent the color red, white, and blue respectively.

**Solution**:
```java
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left++, current++);
            } else if (nums[current] == 2) {
                swap(nums, current, right--);
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors solver = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solver.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

These examples showcase different scenarios where the Two Pointers technique is effectively applied to solve common array problems in an optimal manner.

Certainly! Here are more problems that can be solved using the Two Pointers technique along with their solutions implemented in Java with proper class structures:

### 6. Three Sum
**Problem**: Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

**Solution**:
```java
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solver.threeSum(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
```

### 7. Longest Substring Without Repeating Characters
**Problem**: Given a string `s`, find the length of the longest substring without repeating characters.

**Solution**:
```java
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solver = new LongestSubstringWithoutRepeating();
        String s = "abcabcbb";
        int result = solver.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring: " + result);
    }
}
```

### 8. Find the Duplicate Number
**Problem**: Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive, there is only one repeated number. Find this repeated number.

**Solution**:
```java
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindDuplicate solver = new FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        int result = solver.findDuplicate(nums);
        System.out.println("Duplicate number: " + result);
    }
}
```

### 9. Minimum Size Subarray Sum
**Problem**: Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a contiguous subarray `[numsl, numsl+1, ..., numsr-1, numsr]` of which the sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.

**Solution**:
```java
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen solver = new MinSubArrayLen();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = solver.minSubArrayLen(target, nums);
        System.out.println("Minimum length of subarray: " + result);
    }
}
```

### 10. Merge Two Sorted Arrays
**Problem**: Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` as one sorted array. The number of elements initialized in `nums1` and `nums2` are `m` and `n` respectively. You may assume that `nums1` has enough space (size that is greater or equal to `m + n`) to hold additional elements from `nums2`.

**Solution**:
```java
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays solver = new MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solver.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
```

These examples provide a variety of problems that utilize the Two Pointers technique for efficient solutions.

Certainly! Here are additional problems that can be solved using the Two Pointers technique, along with their solutions implemented in Java with proper class structures:

### 11. Remove Nth Node From End of List
**Problem**: Given the head of a linked list, remove the nth node from the end of the list and return its head.

**Solution**:
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd solver = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = solver.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

### 12. Intersection of Two Arrays II
**Problem**: Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

**Solution**:
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] intersection = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intersection[k] = result.get(k);
        }
        return intersection;
    }

    public static void main(String[] args) {
        IntersectionOfArrays solver = new IntersectionOfArrays();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solver.intersect(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
```

### 13. Valid Palindrome
**Problem**: Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Solution**:
```java
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solver = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean result = solver.isPalindrome(s);
        System.out.println("Is palindrome: " + result);
    }
}
```

### 14. Backspace String Compare
**Problem**: Given two strings `S` and `T`, return if they are equal when both are typed into empty text editors. `#` means a backspace character.

**Solution**:
```java
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare solver = new BackspaceStringCompare();
        String S = "ab#c";
        String T = "ad#c";
        boolean result = solver.backspaceCompare(S, T);
        System.out.println("Strings are equal: " + result);
    }
}
```

### 15. Minimum Window Substring
**Problem**: Given two strings `s` and `t`, return the minimum window in `s` which will contain all the characters in `t`. If there is no such window in `s` that covers all characters in `t`, return the empty string `""`.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int left = 0, right = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tMap.containsKey(c) && windowCounts.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        MinWindowSubstring solver = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solver.minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }
}
```

These examples cover a variety of problems where the Two Pointers technique is used to achieve optimal solutions.

Certainly! Here are additional problems that can be solved using the Two Pointers technique, along with their solutions implemented in Java with proper class structures:

### 16. Merge Intervals
**Problem**: Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

**Solution**:
```java
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solver = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solver.merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
```

### 17. Longest Palindromic Substring
**Problem**: Given a string `s`, return the longest palindromic substring in `s`.

**Solution**:
```java
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solver = new LongestPalindromicSubstring();
        String s = "babad";
        String result = solver.longestPalindrome(s);
        System.out.println("Longest palindromic substring: " + result);
    }
}
```

### 18. Pair with Equal Sum
**Problem**: Given an array of integers, determine if there exist two pairs (a, b) and (c, d) such that a + b = c + d, and a, b, c, and d are distinct elements.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class PairWithEqualSum {
    public boolean hasEqualSumPairs(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(sum)) {
                    int[] pair = map.get(sum);
                    if (pair[0] != i && pair[0] != j && pair[1] != i && pair[1] != j) {
                        return true;
                    }
                } else {
                    map.put(sum, new int[]{i, j});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PairWithEqualSum solver = new PairWithEqualSum();
        int[] nums = {3, 4, 7, 1, 2, 9, 8};
        boolean result = solver.hasEqualSumPairs(nums);
        System.out.println("Has equal sum pairs: " + result);
    }
}
```

### 19. Maximum Number of Ones
**Problem**: Given a matrix with 0's and 1's, find the row with the maximum number of 1's using two pointers.

**Solution**:
```java
public class MaximumNumberOfOnes {
    public int rowWithMaxOnes(int[][] matrix) {
        int maxRow = -1, maxCount = 0;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int j = colCount - 1;

        for (int i = 0; i < rowCount; i++) {
            while (j >= 0 && matrix[i][j] == 1) {
                j--;
                maxRow = i;
            }
        }
        return maxRow;
    }

    public static void main(String[] args) {
        MaximumNumberOfOnes solver = new MaximumNumberOfOnes();
        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };
        int result = solver.rowWithMaxOnes(matrix);
        System.out.println("Row with maximum number of ones: " + result);
    }
}
```

### 20. Reverse Words in a String
**Problem**: Given an input string, reverse the string word by word.

**Solution**:
```java
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWordsInString solver = new ReverseWordsInString();
        String s = "the sky is blue";
        String result = solver.reverseWords(s);
        System.out.println("Reversed words: " + result);
    }
}
```

These examples provide additional problems and solutions that utilize the Two Pointers technique for efficient problem-solving in various scenarios.

Sure! Here are more problems that can be solved using the Two Pointers technique, along with their solutions implemented in Java with proper class structures:

### 21. Move Zeroes
**Problem**: Given an array `nums`, write a function to move all `0`s to the end of it while maintaining the relative order of the non-zero elements.

**Solution**:
```java
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solver = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        solver.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

### 22. Find Pivot Index
**Problem**: Given an array of integers `nums`, write a method that returns the "pivot" index of this array. The pivot index is the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.

**Solution**:
```java
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex solver = new FindPivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = solver.pivotIndex(nums);
        System.out.println("Pivot index: " + result);
    }
}
```

### 23. Max Consecutive Ones
**Problem**: Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

**Solution**:
```java
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solver = new MaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        int result = solver.findMaxConsecutiveOnes(nums);
        System.out.println("Max consecutive ones: " + result);
    }
}
```

### 24. Find All Anagrams in a String
**Problem**: Given a string `s` and a non-empty string `p`, find all the start indices of `p`'s anagrams in `s`. Strings consists of lowercase English letters only and the length of both strings `s` and `p` will not be larger than 20,100.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (isAnagram(sCount, pCount)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if (isAnagram(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private boolean isAnagram(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagrams solver = new FindAllAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solver.findAnagrams(s, p);
        System.out.println("Anagram start indices: " + result);
    }
}
```

### 25. Minimum Number of Steps to Make Two Strings Anagram
**Problem**: Given two strings `s` and `t` of the same length, return the minimum number of steps to make `t` an anagram of `s`. In one step, you can replace any character of `t` with any other character.

**Solution**:
```java
public class MinStepsToAnagram {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        int result = 0;
        for (int i : count) {
            if (i > 0) {
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinStepsToAnagram solver = new MinStepsToAnagram();
        String s = "bab";
        String t = "aba";
        int result = solver.minSteps(s, t);
        System.out.println("Minimum steps to make t anagram of s: " + result);
    }
}
```

These examples provide additional problems and solutions that utilize the Two Pointers technique for efficient problem-solving in various scenarios.

Sure, here are more problems solved using the Two Pointers technique along with their solutions implemented in Java:

### 26. Reverse a String
**Problem**: Write a function that reverses a string. The input string is given as an array of characters `char[]`.

**Solution**:
```java
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString solver = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solver.reverseString(s);
        System.out.println("Reversed string: " + String.valueOf(s));
    }
}
```

### 27. Remove Duplicates from Sorted Array
**Problem**: Given a sorted array `nums`, remove the duplicates in-place such that each element appears only once and returns the new length.

**Solution**:
```java
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates solver = new RemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = solver.removeDuplicates(nums);
        System.out.println("Length after removing duplicates: " + result);
    }
}
```

### 28. Container With Most Water
**Problem**: Given `n` non-negative integers `a1, a2, ..., an`, where each represents a point at coordinate (i, ai). `n` vertical lines are drawn such that the two endpoints of the line `i` are at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

**Solution**:
```java
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solver.maxArea(height);
        System.out.println("Max area: " + result);
    }
}
```

### 29. Sort Colors
**Problem**: Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**Solution**:
```java
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, right, current);
                right--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors solver = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solver.sortColors(nums);
        System.out.println("Sorted colors: " + Arrays.toString(nums));
    }
}
```

### 30. Find the Duplicate Number
**Problem**: Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive, return the duplicate number.

**Solution**:
```java
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindDuplicateNumber solver = new FindDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        int result = solver.findDuplicate(nums);
        System.out.println("Duplicate number: " + result);
    }
}
```

These examples continue to demonstrate the versatility and effectiveness of the Two Pointers technique for solving a variety of problems.

To compare two strings that contain backspaces (represented by the character `#`), you need to simulate the typing process to get the final version of both strings and then compare these final versions.

Here's how you can do it using the two pointers technique:

### Problem
Given two strings `S` and `T`, return if they are equal when both are typed into empty text editors. `#` means a backspace character.

### Solution
1. Use two pointers to traverse both strings from the end to the beginning.
2. Skip characters in both strings when a backspace is encountered.
3. Compare the characters at the current positions of the pointers.

Here's the Java code implementing this solution:

```java
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(backspaceCompare(S, T)); // Output: true

        S = "ab##";
        T = "c#d#";
        System.out.println(backspaceCompare(S, T)); // Output: true

        S = "a##c";
        T = "#a#c";
        System.out.println(backspaceCompare(S, T)); // Output: true

        S = "a#c";
        T = "b";
        System.out.println(backspaceCompare(S, T)); // Output: false
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidIndex(S, i);
            j = getNextValidIndex(T, j);

            if (i < 0 && j < 0) return true; // Both strings have been fully processed
            if (i < 0 || j < 0) return false; // One string has been fully processed while the other has not
            if (S.charAt(i) != T.charAt(j)) return false; // Characters do not match

            i--;
            j--;
        }

        return true;
    }

    private static int getNextValidIndex(String str, int index) {
        int backspaceCount = 0;

        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }
            index--;
        }

        return index;
    }
}
```

### Explanation

1. **getNextValidIndex**: This helper function returns the next valid index in the string by skipping over any characters that should be deleted due to backspaces.
    - If a `#` is encountered, increment the `backspaceCount`.
    - If a non-`#` character is encountered and `backspaceCount` is greater than 0, decrement the `backspaceCount` (indicating this character should be skipped).
    - If a non-`#` character is encountered and `backspaceCount` is 0, this is a valid character.

2. **backspaceCompare**: This function uses the two pointers technique to compare the final versions of the strings.
    - Start from the end of both strings and use the `getNextValidIndex` function to find the next valid character index in each string.
    - Compare the characters at these indices. If they differ, return `false`.
    - Continue moving the pointers to the left and repeat the comparison until both pointers are processed.
    - If both pointers are processed without finding any mismatch, return `true`.

This solution ensures that both strings are processed correctly considering the backspaces, and then compared efficiently.