The sliding window technique is a powerful algorithmic strategy used to solve problems involving arrays or strings. It involves creating a window that slides over the input to maintain a subset of elements and perform operations efficiently. This technique is especially useful when dealing with subarrays or substrings of a fixed or variable size.

### Key Concepts

1. **Fixed-Size Sliding Window**: Used when the size of the window is fixed, e.g., finding the maximum sum of a subarray of size `k`.
2. **Variable-Size Sliding Window**: Used when the size of the window can change, e.g., finding the longest substring with at most `k` distinct characters.

### Common Problems and Solutions

#### 1. Maximum Sum Subarray of Size `K`

**Problem**: Given an array, find the maximum sum of any subarray of size `k`.

**Solution**:
```java
public class MaximumSumSubarrayOfSizeK {
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + findMaxSumSubarray(arr, k)); // Output: 9
    }
}
```

#### 2. Longest Substring with At Most `K` Distinct Characters

**Problem**: Given a string, find the length of the longest substring that contains at most `k` distinct characters.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int longestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0, maxLength = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring with " + k + " distinct characters: " + longestSubstringKDistinct(s, k)); // Output: 3 ("ece")
    }
}
```

### Explanation of the Sliding Window Technique

1. **Initialization**: Define two pointers, `left` and `right`, to represent the window's boundaries. Initialize other variables as needed.
2. **Expand the Window**: Move the `right` pointer to expand the window by including more elements or characters.
3. **Shrink the Window**: Move the `left` pointer to shrink the window when a certain condition is met (e.g., the number of distinct characters exceeds `k`).
4. **Update Results**: As the window slides, update the result based on the current window's state (e.g., the sum of elements, the length of the substring).
5. **Repeat**: Continue expanding and shrinking the window until the end of the array or string is reached.

### Benefits

- **Efficiency**: Sliding window reduces the time complexity compared to a brute force approach that examines all possible subarrays or substrings.
- **Simplicity**: The technique simplifies code by focusing on a moving window rather than handling all possible subarray or substring combinations.

By using the sliding window technique, you can solve various problems related to subarrays and substrings efficiently and effectively.


The sliding window technique is commonly used to solve a variety of problems, particularly those involving arrays or strings. Here is a list of questions that can be solved using the sliding window technique:

### Fixed-Size Sliding Window Problems

1. **Maximum Sum Subarray of Size `K`**
   - Find the maximum sum of any subarray of size `K`.

2. **Minimum Sum Subarray of Size `K`**
   - Find the minimum sum of any subarray of size `K`.

3. **Longest Subarray of Ones After K Flips**
   - Given a binary array, find the longest subarray of 1s that can be obtained by flipping at most `K` 0s.

### Variable-Size Sliding Window Problems

4. **Longest Substring with At Most `K` Distinct Characters**
   - Given a string, find the length of the longest substring that contains at most `K` distinct characters.

5. **Longest Substring with Exactly `K` Distinct Characters**
   - Given a string, find the length of the longest substring that contains exactly `K` distinct characters.

6. **Longest Substring Without Repeating Characters**
   - Given a string, find the length of the longest substring without repeating characters.

7. **Smallest Subarray with Sum Greater Than or Equal to `S`**
   - Given an array of positive integers, find the length of the smallest subarray whose sum is greater than or equal to a given number `S`.

8. **Maximum Sum Subarray of Size Less Than or Equal to `K`**
   - Given an array, find the maximum sum of any subarray with size less than or equal to `K`.

9. **Longest Subarray with Sum at Most `S`**
   - Given an array, find the length of the longest subarray with sum at most `S`.

10. **Sliding Window Maximum**
    - Given an array and an integer `K`, find the maximum element in every contiguous subarray of size `K`.

11. **Sliding Window Minimum**
    - Given an array and an integer `K`, find the minimum element in every contiguous subarray of size `K`.

12. **Count of Anagrams in a String**
    - Given a string and a pattern, find the count of anagrams of the pattern in the string.

13. **Longest Subarray with Absolute Difference Less Than or Equal to Limit**
    - Given an array of integers and an integer limit, find the length of the longest subarray where the absolute difference between any two elements is less than or equal to the limit.

14. **Longest Subarray with Sum Divisible by `K`**
    - Given an array of integers, find the length of the longest subarray with a sum divisible by `K`.

15. **Maximum Consecutive Ones III**
    - Given a binary array `nums` and an integer `K`, find the maximum number of consecutive 1s in the array if you can flip at most `K` 0s.

16. **Longest Subarray with Sum Equals `K`**
    - Given an array of integers and an integer `K`, find the length of the longest subarray that sums to `K`.

17. **Fruit Into Baskets (Longest Subarray with At Most Two Distinct Elements)**
    - Given an array representing types of fruits, find the length of the longest subarray with at most two distinct types of fruits.

### Example Problems with Code

Here are some example problems with code to illustrate the sliding window technique:

#### 1. Maximum Sum Subarray of Size `K`
```java
public class MaximumSumSubarrayOfSizeK {
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + findMaxSumSubarray(arr, k)); // Output: 9
    }
}
```

#### 2. Longest Substring with At Most `K` Distinct Characters
```java
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int longestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0, maxLength = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring with " + k + " distinct characters: " + longestSubstringKDistinct(s, k)); // Output: 3 ("ece")
    }
}
```

These examples illustrate how the sliding window technique can be applied to solve different types of problems efficiently.


Here are some common problems solved using the sliding window technique, along with their solutions in Java:

### 1. Maximum Sum Subarray of Size `K`

**Problem**: Find the maximum sum of any subarray of size `K`.

**Solution**:
```java
public class MaximumSumSubarrayOfSizeK {
    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + findMaxSumSubarray(arr, k)); // Output: 9
    }
}
```

### 2. Longest Substring with At Most `K` Distinct Characters

**Problem**: Find the length of the longest substring that contains at most `K` distinct characters.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int longestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int left = 0, maxLength = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

            while (charCountMap.size() > k) {
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring with " + k + " distinct characters: " + longestSubstringKDistinct(s, k)); // Output: 3 ("ece")
    }
}
```

### 3. Smallest Subarray with Sum Greater Than or Equal to `S`

**Problem**: Find the length of the smallest subarray whose sum is greater than or equal to a given number `S`.

**Solution**:
```java
public class SmallestSubarrayWithSum {
    public static int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= s) {
                minLength = Math.max(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println("Smallest subarray length: " + minSubArrayLen(s, nums)); // Output: 2
    }
}
```

### 4. Longest Substring Without Repeating Characters

**Problem**: Find the length of the longest substring without repeating characters.

**Solution**:
```java
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left++));
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s)); // Output: 3 ("abc")
    }
}
```

### 5. Sliding Window Maximum

**Problem**: Given an array and an integer `K`, find the maximum element in every contiguous subarray of size `K`.

**Solution**:
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.print("Maximum values in each sliding window: ");
        for (int num : result) {
            System.out.print(num + " "); // Output: 3 3 5 5 6 7
        }
    }
}
```

### 6. Longest Subarray of Ones After K Flips

**Problem**: Given a binary array, find the longest subarray of 1s that can be obtained by flipping at most `K` 0s.

**Solution**:
```java
public class LongestSubarrayOnesAfterKFlips {
    public static int longestOnes(int[] A, int K) {
        int left = 0, right;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) K--;
            if (K < 0) {
                if (A[left] == 0) K++;
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        System.out.println("Longest subarray of 1s after " + K + " flips: " + longestOnes(A, K)); // Output: 6
    }
}
```

### 7. Fruit Into Baskets (Longest Subarray with At Most Two Distinct Elements)

**Problem**: Given an array representing types of fruits, find the length of the longest subarray with at most two distinct types of fruits.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, max = 0;

        for (int j = 0; j < tree.length; j++) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);

            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) {
                    count.remove(tree[i]);
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] tree = {1, 2, 1, 2, 3, 2, 2, 2, 3};
        System.out.println("Total fruits that can be collected: " + totalFruit(tree)); // Output: 5
    }
}
```

These problems and solutions illustrate how the sliding window technique can be effectively applied to a wide range of problems involving arrays and strings.


To find the longest subarray containing all 1s in a binary array, you can use a sliding window approach. This approach is efficient with a time complexity of O(n), where n is the length of the array. Here's the Java code to achieve this:

```java
public class LongestSubarrayOfOnes {
    public static int findLongestSubarrayOfOnes(int[] nums) {
        int maxLength = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println("Longest subarray of 1s in nums1: " + findLongestSubarrayOfOnes(nums1)); // Output: 3
        System.out.println("Longest subarray of 1s in nums2: " + findLongestSubarrayOfOnes(nums2)); // Output: 2
    }
}
```

### Explanation:

1. **findLongestSubarrayOfOnes Method**:
   - This method takes a binary array `nums` as input and returns the length of the longest subarray containing all 1s.
   - `maxLength` keeps track of the longest subarray of 1s found so far.
   - `currentLength` keeps track of the current subarray of 1s as the array is iterated.
   - The method iterates through the array:
     - If the current element is 1, `currentLength` is incremented and `maxLength` is updated if `currentLength` exceeds the previous `maxLength`.
     - If the current element is 0, `currentLength` is reset to 0.

2. **Main Method**:
   - This method tests the `findLongestSubarrayOfOnes` method with example binary arrays.
   - It prints the length of the longest subarray of 1s for each example array.

This approach efficiently finds the longest subarray of 1s by maintaining a running count of consecutive 1s and updating the maximum length when necessary.

To find the longest subarray containing all 1s using the sliding window approach, we typically use this approach when there are some allowed modifications (like flipping a certain number of 0s to 1s). However, if we are strictly looking for the longest contiguous subarray of 1s without any modifications, the approach simplifies a bit. But for a more generic solution (where you might allow one flip to maximize the length), here’s how you can achieve it:

### Approach:
1. Use two pointers (`left` and `right`) to represent the window.
2. Expand the `right` pointer to include more elements in the window.
3. If a zero is encountered, increase the count of zeros in the current window.
4. If the count of zeros exceeds the allowed number of flips (for strict all 1s, set allowed flips to 0), move the `left` pointer to the right until the count of zeros is within the allowed limit.
5. Calculate the length of the current window and update the maximum length accordingly.

### Implementation:

Here's the Java code using a sliding window approach:

```java
public class LongestSubarrayOfOnes {
    public static int findLongestSubarrayOfOnes(int[] nums) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;
        int k = 0; // Allowed number of flips (for strictly all 1s, k should be 0)

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println("Longest subarray of 1s in nums1: " + findLongestSubarrayOfOnes(nums1)); // Output: 3
        System.out.println("Longest subarray of 1s in nums2: " + findLongestSubarrayOfOnes(nums2)); // Output: 2
    }
}
```

### Explanation:

1. **Initialization**:
   - `left` pointer is initialized to 0, which marks the beginning of the sliding window.
   - `maxLength` to keep track of the maximum length of the subarray of 1s found.
   - `zeroCount` to keep track of the number of zeros in the current window.
   - `k` is set to 0, meaning no flips are allowed (for strictly finding all 1s).

2. **Sliding Window Expansion**:
   - Iterate through the array using the `right` pointer.
   - When a zero is encountered, increment the `zeroCount`.

3. **Sliding Window Contraction**:
   - If the `zeroCount` exceeds the allowed number of flips (`k`), move the `left` pointer to the right until the `zeroCount` is within the allowed limit.

4. **Updating Maximum Length**:
   - Update `maxLength` with the length of the current valid window (`right - left + 1`).

5. **Main Method**:
   - Test the function with example arrays and print the results.

This sliding window approach ensures that we efficiently find the longest subarray of 1s by maintaining a window of valid subarrays.

Anagrams are strings that can be formed by rearranging the characters of another string using all the original characters exactly once. For example, "listen" and "silent" are anagrams of each other. Here’s how you can work with anagrams in Java, including checking if two strings are anagrams and finding all anagrams of a string within another string.

### 1. Checking if Two Strings are Anagrams

To check if two strings are anagrams, you can sort the characters of both strings and compare them. If they are the same, then the strings are anagrams.

```java
import java.util.Arrays;

public class AnagramChecker {
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Are anagrams: " + areAnagrams(s1, s2)); // Output: true
    }
}
```

### 2. Finding All Anagrams of a String Within Another String

To find all anagrams of a string within another string, you can use a sliding window approach with a frequency counter to keep track of the character counts.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramFinder {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Initial window
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Sliding window
        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length());
            }
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
        }

        // Check the last window
        if (Arrays.equals(pCount, sCount)) {
            result.add(s.length() - p.length());
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagramIndices = findAnagrams(s, p);
        System.out.println("Anagram indices: " + anagramIndices); // Output: [0, 6]
    }
}
```

### Explanation:

1. **Checking if Two Strings are Anagrams**:
   - Convert both strings to character arrays.
   - Sort the character arrays.
   - Compare the sorted arrays. If they are equal, the strings are anagrams.

2. **Finding All Anagrams of a String Within Another String**:
   - Use two frequency arrays `pCount` and `sCount` to keep track of character counts for the target string `p` and the current window in `s`.
   - Populate `pCount` with the character counts of `p`.
   - Populate `sCount` with the character counts of the initial window of length `p` in `s`.
   - Slide the window one character at a time:
     - If the frequency arrays match, the starting index of the current window is an anagram.
     - Update the `sCount` array by adding the next character in the window and removing the first character of the previous window.
   - Finally, check the last window after the loop.

This approach efficiently finds all anagrams by maintaining a sliding window and comparing character counts.
