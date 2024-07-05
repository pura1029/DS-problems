Cyclic sort is an efficient sorting algorithm used mainly for arrays where the elements are in a range from `1` to `N`. The idea is to place each element in its correct position in a single traversal of the array. It works on the principle that if an element is not in its correct position, it can be placed directly in its correct position by swapping it with the element currently at that position. This process is repeated until all elements are in their correct positions.

### Steps of Cyclic Sort:

1. **Initialize a pointer** to iterate through the array.
2. **While the pointer is within the bounds** of the array:
    - **Check if the current element is at its correct position** (i.e., `arr[i] == i + 1`).
    - If it is, move to the next element.
    - If it is not, **swap the element with the element at its correct position** (i.e., `arr[arr[i] - 1]`).
3. Repeat this process until all elements are in their correct positions.

### Example in Java:

Here is a simple Java implementation of Cyclic Sort:

```java
public class CyclicSort {
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                // Swap arr[i] with arr[correctIndex]
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        cyclicSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

### Explanation:

1. **Initialization**: Start with the first element in the array (`i = 0`).
2. **Check Position**: Determine if the current element `arr[i]` is in the correct position by comparing it to `i + 1`.
3. **Swap if Necessary**: If `arr[i]` is not in its correct position, swap it with the element at its target position (`arr[arr[i] - 1]`).
4. **Continue**: If `arr[i]` is in the correct position, move to the next element.
5. **Repeat**: Continue this process until the entire array is sorted.

### Key Points:

- Cyclic sort is especially useful for sorting arrays where elements are in the range from `1` to `N`.
- The algorithm runs in \(O(N)\) time complexity, making it very efficient.
- It sorts the array in place with \(O(1)\) additional space, making it space-efficient.

This sorting technique is quite intuitive and straightforward to implement, especially for arrays with a fixed range of elements.

Sure, here are some common problems that can be efficiently solved using the Cyclic sort technique along with their solutions:

### 1. Find the Missing Number

#### Problem:
Given an array containing N distinct numbers taken from the range 0 to N. Since the array has only N numbers, one number is missing. Find the missing number.

#### Solution:
```java
public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println("Missing number: " + findMissingNumber(arr)); // Output: 2
    }
}
```

### 2. Find All Missing Numbers

#### Problem:
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of the array), some elements appear twice and others appear once. Find all the elements from 1 to n that are missing from the array.

#### Solution:
```java
import java.util.*;

public class AllMissingNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Missing numbers: " + findDisappearedNumbers(arr)); // Output: [5, 6]
    }
}
```

### 3. Find the Duplicate Number

#### Problem:
Given an array of integers containing `n + 1` integers where each integer is in the range `[1, n]` inclusive. There is only one repeated number in the array. Find the duplicate number.

#### Solution:
```java
public class DuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number: " + findDuplicate(arr)); // Output: 3
    }
}
```

### 4. Find All Duplicates

#### Problem:
Given an integer array of size `n` where all the integers are in the range `[1, n]` inclusive, some elements appear twice, and others appear once. Find all the elements that appear twice.

#### Solution:
```java
import java.util.*;

public class AllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicate numbers: " + findDuplicates(arr)); // Output: [2, 3]
    }
}
```

### 5. First Missing Positive

#### Problem:
Given an unsorted integer array, find the smallest missing positive integer.

#### Solution:
```java
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
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

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(arr)); // Output: 2
    }
}
```

These problems illustrate the versatility and efficiency of the Cyclic sort technique for handling various types of sorting and searching problems within a constrained range.

Sure, here are a few more problems that can be solved using the Cyclic sort technique, along with their solutions:

### 6. Find the Smallest Missing Positive Integer

#### Problem:
Given an unsorted integer array, find the smallest missing positive integer.

#### Solution:
```java
public class SmallestMissingPositive {
    public static int findSmallestMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
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

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("Smallest missing positive: " + findSmallestMissingPositive(arr)); // Output: 2
    }
}
```

### 7. Find All Numbers Disappeared in an Array

#### Problem:
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once. Find all the elements of [1, n] inclusive that do not appear in this array.

#### Solution:
```java
import java.util.*;

public class DisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Disappeared numbers: " + findDisappearedNumbers(arr)); // Output: [5, 6]
    }
}
```

### 8. Find the Duplicate Number

#### Problem:
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

#### Solution:
```java
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number: " + findDuplicate(arr)); // Output: 3
    }
}
```

### 9. Find All Duplicates in an Array

#### Problem:
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once. Find all the elements that appear twice in this array.

#### Solution:
```java
import java.util.*;

public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicate numbers: " + findDuplicates(arr)); // Output: [2, 3]
    }
}
```

### 10. Find the First Missing Positive

#### Problem:
Given an unsorted integer array, find the smallest missing positive integer.

#### Solution:
```java
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
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

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(arr)); // Output: 2
    }
}
```

These additional problems and solutions further illustrate the practical use of the Cyclic sort technique in solving various types of problems that involve sorting and finding missing or duplicate numbers within a constrained range.

Certainly! Here are a few more questions and their solutions that use the Cyclic sort technique:

### 11. Find Missing and Duplicate Numbers

#### Problem:
Given an array of integers where each integer is in the range from 1 to n, and each integer appears exactly once except one number which is missing and another number which appears twice. Find the missing and duplicate numbers.

#### Solution:
```java
public class MissingAndDuplicate {
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }
        return new int[] {-1, -1}; // This line should never be reached
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        int[] result = findErrorNums(arr);
        System.out.println("Duplicate number: " + result[0] + ", Missing number: " + result[1]); // Output: Duplicate number: 2, Missing number: 3
    }
}
```

### 12. Find the Kth Smallest Missing Positive Number

#### Problem:
Given an array of integers where each integer is in the range from 1 to n and each integer appears exactly once except some integers which are missing. Find the kth smallest missing positive integer.

#### Solution:
```java
public class KthSmallestMissing {
    public static int findKthSmallestMissing(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int missingCount = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingCount++;
                if (missingCount == k) {
                    return i + 1;
                }
            }
        }
        
        return nums.length + k - missingCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println("Kth smallest missing number: " + findKthSmallestMissing(arr, k)); // Output: 9
    }
}
```

### 13. Find Missing Ranges

#### Problem:
Given a sorted integer array `nums`, where the range of elements are in the inclusive range `[lower, upper]`, return its missing ranges.

#### Solution:
```java
import java.util.*;

public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= curr - 1) {
                result.add(formatRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        
        return result;
    }
    
    private static String formatRange(int lower, int upper) {
        return (lower == upper) ? String.valueOf(lower) : lower + "->" + upper;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
        System.out.println("Missing ranges: " + findMissingRanges(arr, lower, upper)); // Output: [2, 4->49, 51->74, 76->99]
    }
}
```

### 14. Find the First Missing Positive from an Unsorted Array

#### Problem:
Given an unsorted integer array, find the smallest missing positive integer.

#### Solution:
```java
public class FirstMissingPositiveUnsorted {
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
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

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(arr)); // Output: 2
    }
}
```

### 15. Find the Second Smallest Missing Positive Number

#### Problem:
Given an unsorted integer array, find the second smallest missing positive integer.

#### Solution:
```java
public class SecondSmallestMissingPositive {
    public static int findSecondSmallestMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int missingCount = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingCount++;
                if (missingCount == 2) {
                    return i + 1;
                }
            }
        }
        return nums.length + 2 - missingCount;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("Second smallest missing positive: " + findSecondSmallestMissingPositive(arr)); // Output: 5
    }
}
```

These additional problems and solutions further demonstrate the utility of the Cyclic sort technique for solving a variety of problems that involve finding missing or duplicate numbers within a specific range.

Certainly! Here are more questions and their solutions using the Cyclic sort technique:

### 16. Find All Elements Appearing More Than Once

#### Problem:
Given an array of integers where each integer appears exactly once except for one integer which appears twice. Find the integer that appears twice.

#### Solution:
```java
import java.util.*;

public class ElementsAppearingMoreThanOnce {
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicates: " + findDuplicates(arr)); // Output: [2, 3]
    }
}
```

### 17. Find the Duplicate Number in an Array

#### Problem:
Given an array of integers where each integer appears exactly once except for one integer which appears twice. Find the integer that appears twice.

#### Solution:
```java
public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + findDuplicate(arr)); // Output: 2
    }
}
```

### 18. Find Missing Positive in an Array

#### Problem:
Given an unsorted integer array, find the smallest missing positive integer.

#### Solution:
```java
public class MissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
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

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(arr)); // Output: 2
    }
}
```

### 19. Find All Numbers Disappeared in an Array

#### Problem:
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once. Find all the elements of [1, n] inclusive that do not appear in this array.

#### Solution:
```java
import java.util.*;

public class AllNumbersDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Disappeared numbers: " + findDisappearedNumbers(arr)); // Output: [5, 6]
    }
}
```

### 20. Find All Duplicates in an Array

#### Problem:
Given an array of integers where each integer appears exactly once except for one integer which appears twice. Find the integer that appears twice.

#### Solution:
```java
import java.util.*;

public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicates: " + findDuplicates(arr)); // Output: [2, 3]
    }
}
```

These additional problems and solutions further demonstrate the versatility and efficiency of the Cyclic sort technique in solving various types of problems involving missing or duplicate numbers within a specific range.


Certainly! Here are a few more questions and their solutions using the Cyclic sort technique:

### 21. Find the Kth Smallest Missing Positive Number in Unsorted Array

#### Problem:
Given an unsorted integer array, find the kth smallest missing positive integer.

#### Solution:
```java
public class KthSmallestMissingPositive {
    public static int findKthSmallestMissing(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int missingCount = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingCount++;
                if (missingCount == k) {
                    return i + 1;
                }
            }
        }
        return nums.length + k - missingCount;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int k = 2;
        System.out.println("Kth smallest missing positive: " + findKthSmallestMissing(arr, k)); // Output: 5
    }
}
```

### 22. Find All Numbers Appearing More Than Twice

#### Problem:
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice, some appear once, and some might appear more than twice. Find all elements that appear more than twice.

#### Solution:
```java
import java.util.*;

public class NumbersAppearingMoreThanTwice {
    public static List<Integer> findNumbersAppearingMoreThanTwice(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }

        // Remove duplicates from the result list
        Set<Integer> unique = new HashSet<>(result);
        result.clear();
        result.addAll(unique);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1, 3};
        System.out.println("Numbers appearing more than twice: " + findNumbersAppearingMoreThanTwice(arr)); // Output: [3]
    }
}
```

### 23. Find the Largest Missing Positive Integer

#### Problem:
Given an unsorted integer array, find the largest missing positive integer less than or equal to the length of the array.

#### Solution:
```java
public class LargestMissingPositive {
    public static int findLargestMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = nums.length; i > 0; i--) {
            if (nums[i - 1] != i) {
                return i;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("Largest missing positive: " + findLargestMissingPositive(arr)); // Output: 2
    }
}
```

### 24. Find the Second Largest Missing Positive Integer

#### Problem:
Given an unsorted integer array, find the second largest missing positive integer less than or equal to the length of the array.

#### Solution:
```java
public class SecondLargestMissingPositive {
    public static int findSecondLargestMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        int missingCount = 0;
        for (i = nums.length; i > 0; i--) {
            if (nums[i - 1] != i) {
                missingCount++;
                if (missingCount == 2) {
                    return i;
                }
            }
        }
        return nums.length + 2 - missingCount;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("Second largest missing positive: " + findSecondLargestMissingPositive(arr)); // Output: 1
    }
}
```

### 25. Find the First K Missing Positive Numbers

#### Problem:
Given an unsorted integer array, find the first K missing positive integers.

#### Solution:
```java
import java.util.*;

public class FirstKMissingPositive {
    public static List<Integer> findFirstKMissingPositive(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraNumbers.add(nums[i]);
                if (missingNumbers.size() == k) {
                    return missingNumbers;
                }
            }
        }

        // Add the remaining missing numbers
        for (i = 1; missingNumbers.size() < k; i++) {
            int candidateNumber = nums.length + i;
            if (!extraNumbers.contains(candidateNumber)) {
                missingNumbers.add(candidateNumber);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int k = 3;
        System.out.println("First K missing positives: " + findFirstKMissingPositive(arr, k)); // Output: [2, 5, 6]
    }
}
```

These additional problems and solutions provide further insight into how the Cyclic sort technique can be applied to a variety of scenarios involving missing or duplicate numbers within a specific range.

