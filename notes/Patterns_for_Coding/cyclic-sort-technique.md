Cyclic sort is a technique used to sort an array of integers that are supposed to be in the range 1 to N (where N is the size of the array). Here's how it works in Java:

1. **Understanding the Technique**:
    - Cyclic sort works by placing each number in its correct position in the array. For example, if you have an array with elements from 1 to N, after sorting, the first element will contain 1, the second element will contain 2, and so on.

2. **Implementation Steps**:
    - Start iterating through the array.
    - For each element at index i, check if it is in the correct position (i.e., array[i] should be equal to i + 1 for 0-based indexing).
    - If it is not in the correct position, swap it with the element at the position array[i] - 1 (because array indices are 0-based but the numbers are 1-based).
    - Repeat until all elements are in their correct positions.

3. **Java Code Example**:
   Here’s a simple Java code example to demonstrate cyclic sort:

   ```java
   public class CyclicSort {
       public static void sort(int[] nums) {
           int i = 0;
           while (i < nums.length) {
               if (nums[i] != nums[nums[i] - 1]) { // Check if the current element is in the correct position
                   // Swap nums[i] with nums[nums[i] - 1]
                   int temp = nums[nums[i] - 1];
                   nums[nums[i] - 1] = nums[i];
                   nums[i] = temp;
               } else {
                   i++;
               }
           }
       }

       public static void main(String[] args) {
           int[] arr = {3, 1, 5, 4, 2}; // Example array
           sort(arr);
           for (int num : arr) {
               System.out.print(num + " ");
           }
       }
   }
   ```

4. **Explanation of the Example**:
    - In this example, `sort(int[] nums)` method implements the cyclic sort algorithm.
    - The `while` loop runs until all elements are in their correct positions.
    - Inside the loop, if the current element is not in its correct position, it swaps with the element at the correct position.
    - Finally, the sorted array is printed.

5. **Complexity**:
    - Time Complexity: O(N) where N is the number of elements in the array, because each element is placed in its correct position in constant time.
    - Space Complexity: O(1), because the sorting is done in-place without using any extra space apart from a few variables.

Cyclic sort is particularly useful when you need to sort an array where elements are supposed to be in a specific range, such as 1 to N, and can be very efficient in such cases.

Certainly! The cyclic sort technique is particularly useful for problems where you have an array of integers that are supposed to be in a specific range or permutation. Here are some common problems that can be solved using cyclic sort along with their solutions:

1. **Find the Duplicate Number**:
    - **Problem**: Given an array of integers nums containing n + 1 integers where each integer is between 1 and n (inclusive), find the duplicate number.
    - **Solution**: Use cyclic sort to place each number in its correct position. The first number that fails to move to its correct position is the duplicate.
      ```java
      public int findDuplicate(int[] nums) {
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  return nums[i];
              }
          }
          return -1; // Not found (shouldn't reach here as per problem constraints)
      }
      ```

2. **Find All Missing Numbers in an Array**:
    - **Problem**: Given an array of integers where 1 ≤ a[i] ≤ n (n is the size of the array), some elements appear twice and others appear once. Find all the elements of [1, n] inclusive that do not appear in this array.
    - **Solution**: Similar to above, use cyclic sort to find and collect all missing numbers.
      ```java
      public List<Integer> findDisappearedNumbers(int[] nums) {
          List<Integer> missing = new ArrayList<>();
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  missing.add(i + 1);
              }
          }
          return missing;
      }
      ```

3. **Sort Colors (Dutch National Flag Problem)**:
    - **Problem**: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
    - **Solution**: Use cyclic sort to partition the array into three sections.
      ```java
      public void sortColors(int[] nums) {
          int i = 0, left = 0, right = nums.length - 1;
          while (i <= right) {
              if (nums[i] == 0) {
                  // Swap nums[i] with nums[left]
                  int temp = nums[left];
                  nums[left] = nums[i];
                  nums[i] = temp;
                  left++;
                  i++;
              } else if (nums[i] == 2) {
                  // Swap nums[i] with nums[right]
                  int temp = nums[right];
                  nums[right] = nums[i];
                  nums[i] = temp;
                  right--;
              } else {
                  i++;
              }
          }
      }
      ```

4. **Find the Missing Positive**:
    - **Problem**: Given an unsorted integer array nums, find the smallest missing positive integer.
    - **Solution**: Use cyclic sort to rearrange the array so that nums[i] equals i + 1. Then, iterate through to find the first missing positive.
      ```java
      public int firstMissingPositive(int[] nums) {
          int i = 0;
          while (i < nums.length) {
              if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  return i + 1;
              }
          }
          return nums.length + 1;
      }
      ```

These examples demonstrate how cyclic sort can be applied effectively to solve a variety of array-related problems where elements are expected to be in a specific range or order.

Certainly! The cyclic sort technique is particularly useful for problems where you have an array of integers that are supposed to be in a specific range or permutation. Here are some common problems that can be solved using cyclic sort along with their solutions:

1. **Find the Duplicate Number**:
    - **Problem**: Given an array of integers nums containing n + 1 integers where each integer is between 1 and n (inclusive), find the duplicate number.
    - **Solution**: Use cyclic sort to place each number in its correct position. The first number that fails to move to its correct position is the duplicate.
      ```java
      public int findDuplicate(int[] nums) {
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  return nums[i];
              }
          }
          return -1; // Not found (shouldn't reach here as per problem constraints)
      }
      ```

2. **Find All Missing Numbers in an Array**:
    - **Problem**: Given an array of integers where 1 ≤ a[i] ≤ n (n is the size of the array), some elements appear twice and others appear once. Find all the elements of [1, n] inclusive that do not appear in this array.
    - **Solution**: Similar to above, use cyclic sort to find and collect all missing numbers.
      ```java
      public List<Integer> findDisappearedNumbers(int[] nums) {
          List<Integer> missing = new ArrayList<>();
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  missing.add(i + 1);
              }
          }
          return missing;
      }
      ```

3. **Sort Colors (Dutch National Flag Problem)**:
    - **Problem**: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
    - **Solution**: Use cyclic sort to partition the array into three sections.
      ```java
      public void sortColors(int[] nums) {
          int i = 0, left = 0, right = nums.length - 1;
          while (i <= right) {
              if (nums[i] == 0) {
                  // Swap nums[i] with nums[left]
                  int temp = nums[left];
                  nums[left] = nums[i];
                  nums[i] = temp;
                  left++;
                  i++;
              } else if (nums[i] == 2) {
                  // Swap nums[i] with nums[right]
                  int temp = nums[right];
                  nums[right] = nums[i];
                  nums[i] = temp;
                  right--;
              } else {
                  i++;
              }
          }
      }
      ```

4. **Find the Missing Positive**:
    - **Problem**: Given an unsorted integer array nums, find the smallest missing positive integer.
    - **Solution**: Use cyclic sort to rearrange the array so that nums[i] equals i + 1. Then, iterate through to find the first missing positive.
      ```java
      public int firstMissingPositive(int[] nums) {
          int i = 0;
          while (i < nums.length) {
              if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  return i + 1;
              }
          }
          return nums.length + 1;
      }
      ```

These examples demonstrate how cyclic sort can be applied effectively to solve a variety of array-related problems where elements are expected to be in a specific range or order.

Certainly! Here are more problems that can be effectively solved using the cyclic sort technique:

5. **Find All Duplicate Numbers in an Array**:
    - **Problem**: Given an array of integers nums containing n integers where each integer is between 1 and n, count all the duplicate numbers.
    - **Solution**: Use cyclic sort to find and count duplicate numbers.
      ```java
      public List<Integer> findDuplicates(int[] nums) {
          List<Integer> duplicates = new ArrayList<>();
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  duplicates.add(nums[i]);
              }
          }
          return duplicates;
      }
      ```

6. **Find the Smallest Missing Positive Integer**:
    - **Problem**: Given an unsorted integer array nums, find the smallest missing positive integer.
    - **Solution**: Use cyclic sort to move each positive integer to its correct position and then find the first missing positive.
      ```java
      public int firstMissingPositive(int[] nums) {
          int i = 0;
          while (i < nums.length) {
              if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  return i + 1;
              }
          }
          return nums.length + 1;
      }
      ```

7. **Find All Missing and Duplicate Numbers**:
    - **Problem**: Given an array of integers where 1 ≤ a[i] ≤ n (n is the size of the array), some elements appear twice and others appear once. Find all the missing and duplicate numbers.
    - **Solution**: Use cyclic sort to identify all missing and duplicate numbers in the array.
      ```java
      public List<List<Integer>> findMissingAndDuplicates(int[] nums) {
          List<Integer> missing = new ArrayList<>();
          List<Integer> duplicates = new ArrayList<>();
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  duplicates.add(nums[i]);
                  missing.add(i + 1);
              }
          }
          List<List<Integer>> result = new ArrayList<>();
          result.add(missing);
          result.add(duplicates);
          return result;
      }
      ```

8. **Find the First K Missing Positive Numbers**:
    - **Problem**: Given an unsorted integer array nums, find the first K missing positive numbers.
    - **Solution**: Use cyclic sort to rearrange the array so that nums[i] equals i + 1 and collect the first K missing positive numbers.
      ```java
      public List<Integer> findFirstKMissingPositive(int[] nums, int k) {
          List<Integer> missing = new ArrayList<>();
          int i = 0;
          while (i < nums.length) {
              if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          i = 0;
          int count = 0;
          while (count < k && i < nums.length) {
              if (nums[i] != i + 1) {
                  missing.add(i + 1);
                  count++;
              }
              i++;
          }
          while (count < k) {
              missing.add(++i);
              count++;
          }
          return missing;
      }
      ```

These additional examples showcase the versatility of cyclic sort for solving array-related problems efficiently, especially when elements are constrained within a specific range or permutation.

Certainly! Here are a few more problems that can be effectively solved using the cyclic sort technique:

9. **Find All Numbers Disappeared in an Array**:
    - **Problem**: Given an array of integers where 1 ≤ a[i] ≤ n (n is the size of the array), some elements appear once and others appear twice. Find all the elements of [1, n] inclusive that do not appear in this array.
    - **Solution**: Use cyclic sort to find and collect all missing numbers.
      ```java
      public List<Integer> findDisappearedNumbers(int[] nums) {
          List<Integer> missing = new ArrayList<>();
          int i = 0;
          while (i < nums.length) {
              if (nums[i] != nums[nums[i] - 1]) {
                  // Swap nums[i] with nums[nums[i] - 1]
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  missing.add(i + 1);
              }
          }
          return missing;
      }
      ```

10. **Find All K-Length Subarrays with Maximum Sum**:
    - **Problem**: Given an array of integers, find all subarrays of length k with the maximum sum.
    - **Solution**: Use cyclic sort to efficiently compute the sum of each k-length subarray.
      ```java
      public List<int[]> findMaxSumSubarrays(int[] nums, int k) {
          List<int[]> result = new ArrayList<>();
          int maxSum = Integer.MIN_VALUE;
          int currentSum = 0;
          int startIndex = 0;

          // Calculate sum of the first window
          for (int i = 0; i < k; i++) {
              currentSum += nums[i];
          }
          maxSum = currentSum;
          result.add(new int[]{startIndex, startIndex + k - 1});

          // Slide window and calculate sum for remaining subarrays
          for (int i = k; i < nums.length; i++) {
              currentSum += nums[i] - nums[i - k]; // slide window
              if (currentSum > maxSum) {
                  maxSum = currentSum;
                  startIndex = i - k + 1;
                  result.clear();
                  result.add(new int[]{startIndex, startIndex + k - 1});
              } else if (currentSum == maxSum) {
                  result.add(new int[]{i - k + 1, i});
              }
          }

          return result;
      }
      ```

11. **Sort an Almost Sorted Array (K-sorted array)**:
    - **Problem**: Given an array where each element is at most k positions away from its sorted position, sort the array.
    - **Solution**: Use cyclic sort to maintain a window of k elements and sort each window individually.
      ```java
      public void sortKSortedArray(int[] nums, int k) {
          PriorityQueue<Integer> minHeap = new PriorityQueue<>();
          // Insert first k elements into min heap
          for (int i = 0; i <= k && i < nums.length; i++) {
              minHeap.offer(nums[i]);
          }
          int index = 0;
          for (int i = k + 1; i < nums.length; i++) {
              nums[index++] = minHeap.poll(); // remove smallest element
              minHeap.offer(nums[i]); // add next element to heap
          }
          // Extract remaining elements from heap
          while (!minHeap.isEmpty()) {
              nums[index++] = minHeap.poll();
          }
      }
      ```

12. **Find the Kth Missing Positive Number**:
    - **Problem**: Given an array arr of positive integers sorted in a strictly increasing order, and an integer k, find the kth missing positive integer.
    - **Solution**: Use cyclic sort to identify and count missing positive integers until you reach the kth missing positive integer.
      ```java
      public int findKthMissingPositive(int[] arr, int k) {
          int i = 0, missingCount = 0, num = 1;

          while (missingCount < k) {
              if (i < arr.length && arr[i] == num) {
                  i++;
              } else {
                  missingCount++;
              }
              if (missingCount == k) {
                  return num;
              }
              num++;
          }
          return -1; // Shouldn't reach here based on problem constraints
      }
      ```

These problems illustrate different applications of the cyclic sort technique, demonstrating its effectiveness in solving array-related challenges efficiently.

Certainly! Here are a few more problems that can be effectively solved using the cyclic sort technique:

13. **Find the Minimum Swaps Required to Sort an Array**:
    - **Problem**: Given an array of integers, find the minimum number of adjacent swaps required to sort the array in ascending order.
    - **Solution**: Use cyclic sort to count the number of swaps needed to sort the array.
      ```java
      public int minSwaps(int[] nums) {
          int swaps = 0, i = 0;
          while (i < nums.length) {
              if (nums[i] != i + 1) {
                  int temp = nums[i];
                  nums[i] = nums[temp - 1];
                  nums[temp - 1] = temp;
                  swaps++;
              } else {
                  i++;
              }
          }
          return swaps;
      }
      ```

14. **Find All Unique Triplets that Sum to Zero**:
    - **Problem**: Given an array nums of n integers, find all unique triplets in the array which gives the sum of zero.
    - **Solution**: Use cyclic sort along with two-pointer technique to find triplets that sum to zero.
      ```java
      public List<List<Integer>> threeSum(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
          Arrays.sort(nums);
          for (int i = 0; i < nums.length - 2; i++) {
              if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                  int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                  while (lo < hi) {
                      if (nums[lo] + nums[hi] == sum) {
                          result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                          while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                          while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                          lo++;
                          hi--;
                      } else if (nums[lo] + nums[hi] < sum) {
                          lo++;
                      } else {
                          hi--;
                      }
                  }
              }
          }
          return result;
      }
      ```

15. **Find the Smallest Positive Missing Integer**:
    - **Problem**: Given an unsorted integer array nums, find the smallest positive integer that does not exist in the array.
    - **Solution**: Use cyclic sort to rearrange the array so that nums[i] equals i + 1, then iterate to find the smallest missing positive integer.
      ```java
      public int firstMissingPositive(int[] nums) {
          int i = 0;
          while (i < nums.length) {
              if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums[i];
                  nums[i] = temp;
              } else {
                  i++;
              }
          }
          for (i = 0; i < nums.length; i++) {
              if (nums[i] != i + 1) {
                  return i + 1;
              }
          }
          return nums.length + 1;
      }
      ```

16. **Sort an Array of 0s, 1s, and 2s (Dutch National Flag Problem)**:
    - **Problem**: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order 0, 1, and 2.
    - **Solution**: Use cyclic sort to partition the array into three sections.
      ```java
      public void sortColors(int[] nums) {
          int i = 0, left = 0, right = nums.length - 1;
          while (i <= right) {
              if (nums[i] == 0) {
                  // Swap nums[i] with nums[left]
                  int temp = nums[left];
                  nums[left] = nums[i];
                  nums[i] = temp;
                  left++;
                  i++;
              } else if (nums[i] == 2) {
                  // Swap nums[i] with nums[right]
                  int temp = nums[right];
                  nums[right] = nums[i];
                  nums[i] = temp;
                  right--;
              } else {
                  i++;
              }
          }
      }
      ```

These problems demonstrate various applications of the cyclic sort technique, showcasing its utility in solving array-related challenges efficiently.

