Recursion is a programming technique where a method calls itself to solve a problem. In Java, recursion can be used to solve problems that can be broken down into smaller, similar problems. Here's a simple example of a recursive method in Java to calculate the factorial of a number:

```java
public class Factorial {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}
```

### Key Concepts:
1. **Base Case**: This is the condition under which the recursion ends. Without a base case, the method would call itself indefinitely, leading to a stack overflow error.
2. **Recursive Case**: This is where the method calls itself with modified arguments, gradually approaching the base case.

### Example: Fibonacci Series
Here’s another example of a recursive method to calculate the nth Fibonacci number:

```java
public class Fibonacci {
    // Recursive method to calculate Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int number = 10;
        int result = fibonacci(number);
        System.out.println("Fibonacci number " + number + " is " + result);
    }
}
```

### Important Considerations:
- **Performance**: Recursive solutions can be less efficient than iterative ones due to the overhead of multiple method calls. For instance, the naive recursive Fibonacci implementation has exponential time complexity.
- **Stack Overflow**: Deep recursion can lead to stack overflow errors if the base case is not reached quickly enough. This is due to the limited stack space available for method calls.
- **Memoization**: This technique can optimize recursive solutions by storing the results of expensive function calls and reusing them when the same inputs occur again. This is particularly useful in problems like calculating Fibonacci numbers.

Using recursion effectively involves understanding the problem and recognizing patterns that can be broken down into simpler sub-problems.

Here is a list of common problems that can be solved using recursion, along with Java class implementations for each:

### 1. Factorial Calculation
**Problem**: Calculate the factorial of a number \( n \).

**Solution**:
```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}
```

### 2. Fibonacci Series
**Problem**: Find the nth Fibonacci number.

**Solution**:
```java
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int number = 10;
        int result = fibonacci(number);
        System.out.println("Fibonacci number " + number + " is " + result);
    }
}
```

### 3. Sum of Array Elements
**Problem**: Find the sum of all elements in an array.

**Solution**:
```java
public class ArraySum {
    public static int sumArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumArray(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int result = sumArray(array, 0);
        System.out.println("Sum of array elements is " + result);
    }
}
```

### 4. String Reversal
**Problem**: Reverse a string.

**Solution**:
```java
public class StringReversal {
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String original = "Hello";
        String reversed = reverseString(original);
        System.out.println("Reversed string is " + reversed);
    }
}
```

### 5. Binary Search
**Problem**: Perform a binary search on a sorted array.

**Solution**:
```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int result = binarySearch(array, target, 0, array.length - 1);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
```

### 6. Tower of Hanoi
**Problem**: Solve the Tower of Hanoi problem.

**Solution**:
```java
public class TowerOfHanoi {
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        solveHanoi(numberOfDisks, 'A', 'C', 'B');
    }
}
```

### 7. Permutations of a String
**Problem**: Generate all permutations of a given string.

**Solution**:
```java
public class StringPermutations {
    public static void permute(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, result + ch);
        }
    }

    public static void main(String[] args) {
        String original = "ABC";
        permute(original, "");
    }
}
```

These problems and solutions demonstrate the power and flexibility of recursion in solving a variety of computational problems.

Sure, here are additional problems solved using recursion with their corresponding Java class implementations:

### 8. GCD (Greatest Common Divisor)
**Problem**: Find the greatest common divisor (GCD) of two numbers.

**Solution**:
```java
public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 56;
        int b = 98;
        int result = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is " + result);
    }
}
```

### 9. Power Calculation
**Problem**: Calculate \( x \) raised to the power \( n \) (i.e., \( x^n \)).

**Solution**:
```java
public class PowerCalculation {
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / power(x, -n);
        } else if (n % 2 == 0) {
            double halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static void main(String[] args) {
        double base = 2;
        int exponent = 10;
        double result = power(base, exponent);
        System.out.println(base + " raised to the power " + exponent + " is " + result);
    }
}
```

### 10. Palindrome Check
**Problem**: Check if a string is a palindrome.

**Solution**:
```java
public class PalindromeCheck {
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String str = "madam";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println(str + " is a palindrome: " + result);
    }
}
```

### 11. Sum of Digits
**Problem**: Calculate the sum of the digits of a number.

**Solution**:
```java
public class SumOfDigits {
    public static int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        int number = 1234;
        int result = sumDigits(number);
        System.out.println("Sum of digits of " + number + " is " + result);
    }
}
```

### 12. Count Occurrences of a Character in a String
**Problem**: Count the number of times a character appears in a string.

**Solution**:
```java
public class CountCharacter {
    public static int countChar(String str, char ch) {
        if (str.isEmpty()) {
            return 0;
        }
        int count = (str.charAt(0) == ch) ? 1 : 0;
        return count + countChar(str.substring(1), ch);
    }

    public static void main(String[] args) {
        String str = "hello world";
        char ch = 'o';
        int result = countChar(str, ch);
        System.out.println("The character '" + ch + "' appears " + result + " times in the string.");
    }
}
```

### 13. Subset Sum Problem
**Problem**: Determine if there is a subset of the given set with a sum equal to a given sum.

**Solution**:
```java
public class SubsetSum {
    public static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean result = isSubsetSum(set, set.length, sum);
        System.out.println("Is there a subset with sum " + sum + "? " + result);
    }
}
```

### 14. Print All Subsequences of a String
**Problem**: Print all subsequences of a given string.

**Solution**:
```java
public class Subsequences {
    public static void printSubsequences(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }
        printSubsequences(str.substring(1), result + str.charAt(0));
        printSubsequences(str.substring(1), result);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences(str, "");
    }
}
```

### 15. Merge Sort
**Problem**: Implement the merge sort algorithm.

**Solution**:
```java
public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
```

These additional examples cover a range of common problems that can be elegantly solved using recursion in Java.

Here are additional recursion-based problems with their solutions in Java:

### 16. N-Queens Problem
**Problem**: Place N queens on an N×N chessboard such that no two queens threaten each other.

**Solution**:
```java
public class NQueens {
    public static boolean solveNQueens(int[][] board, int col) {
        if (col >= board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueens(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
```

### 17. Generate Parentheses
**Problem**: Generate all combinations of well-formed parentheses given n pairs of parentheses.

**Solution**:
```java
public class GenerateParentheses {
    public static void generateParentheses(int n, int open, int close, String result) {
        if (open == n && close == n) {
            System.out.println(result);
            return;
        }
        if (open < n) {
            generateParentheses(n, open + 1, close, result + "(");
        }
        if (close < open) {
            generateParentheses(n, open, close + 1, result + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParentheses(n, 0, 0, "");
    }
}
```

### 18. Subset Generation
**Problem**: Generate all subsets of a given set of integers.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    public static void generateSubsets(int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            System.out.println(current);
            return;
        }
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current);
        current.remove(current.size() - 1);
        generateSubsets(nums, index + 1, current);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        generateSubsets(nums, 0, new ArrayList<>());
    }
}
```

### 19. Combination Sum
**Problem**: Find all unique combinations in a set of candidates where the candidate numbers sum to a target.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combinationSum(int[] candidates, int target, List<Integer> current, int start) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], current, i);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target, new ArrayList<>(), 0);
    }
}
```

### 20. Word Search
**Problem**: Given a 2D board and a word, find if the word exists in the grid.

**Solution**:
```java
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean result = exist(board, word);
        System.out.println("Word exists: " + result);
    }
}
```

### 21. Climbing Stairs
**Problem**: Given a staircase with `n` steps, you can climb 1 or 2 steps at a time. Calculate the number of distinct ways to reach the top.

**Solution**:
```java
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int steps = 5;
        int ways = climbStairs(steps);
        System.out.println("Number of ways to climb " + steps + " steps: " + ways);
    }
}
```

### 22. Print All Paths in a Matrix
**Problem**: Print all paths from the top-left corner to the bottom-right corner of a matrix.

**Solution**:
```java
public class MatrixPaths {
    public static void printPaths(int[][] matrix, int i, int j, String path) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i == m - 1 && j == n - 1) {
            System.out.println(path + matrix[i][j]);
            return;
        }

        if (i < m - 1) {
            printPaths(matrix, i + 1, j, path + matrix[i][j] + "->");
        }

        if (j < n - 1) {
            printPaths(matrix, i, j + 1, path + matrix[i][j] + "->");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printPaths(matrix, 0, 0, "");
    }
}
```

### 23. Sum of Nodes in a Binary Tree
**Problem**: Find the sum of all nodes in a binary tree.

**Solution**:
```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeSum {
    public static int sumNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int sum = sumNodes(root);
        System.out.println("Sum of all nodes: " + sum);
    }
}
```

### 24. Flatten a Binary Tree to Linked List
**Problem**: Flatten a binary tree to a linked list in-place.

**Solution**:
```java
class

 TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
    }
}
```

These additional examples cover a variety of problems that can be solved using recursion in Java, demonstrating the technique's versatility and power.

Certainly! Here are more problems with solutions using recursion in Java:

### 25. Find the Maximum Element in an Array
**Problem**: Find the maximum element in an array.

**Solution**:
```java
public class MaxElement {
    public static int findMax(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 45, 6, 10, -8};
        int max = findMax(array, array.length);
        System.out.println("Maximum element in the array is: " + max);
    }
}
```

### 26. All Permutations of an Array
**Problem**: Generate all permutations of a given array.

**Solution**:
```java
import java.util.Arrays;

public class ArrayPermutations {
    public static void permute(int[] arr, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r);
                swap(arr, l, i); // backtrack
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        permute(array, 0, array.length - 1);
    }
}
```

### 27. Sum of All Subsets
**Problem**: Calculate the sum of all subsets of a given set of integers.

**Solution**:
```java
public class SubsetSum {
    public static void sumOfSubsets(int[] nums, int index, int currentSum) {
        if (index == nums.length) {
            System.out.println("Subset sum: " + currentSum);
            return;
        }
        sumOfSubsets(nums, index + 1, currentSum + nums[index]);
        sumOfSubsets(nums, index + 1, currentSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        sumOfSubsets(nums, 0, 0);
    }
}
```

### 28. Count Ways to Reach Nth Stair
**Problem**: Count the number of ways to reach the nth stair if you can take either 1 or 2 steps at a time.

**Solution**:
```java
public class CountWays {
    public static int countWays(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        int ways = countWays(n);
        System.out.println("Number of ways to reach the " + n + "th stair: " + ways);
    }
}
```

### 29. Find the Length of a String
**Problem**: Find the length of a string without using any built-in functions.

**Solution**:
```java
public class StringLength {
    public static int findLength(String str) {
        if (str.equals("")) {
            return 0;
        }
        return findLength(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String str = "hello";
        int length = findLength(str);
        System.out.println("Length of the string \"" + str + "\" is: " + length);
    }
}
```

### 30. Decimal to Binary Conversion
**Problem**: Convert a decimal number to its binary representation.

**Solution**:
```java
public class DecimalToBinary {
    public static void decimalToBinary(int n) {
        if (n > 0) {
            decimalToBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        int number = 10;
        System.out.print("Binary representation of " + number + " is: ");
        decimalToBinary(number);
    }
}
```

### 31. Flatten a Linked List
**Problem**: Flatten a multilevel linked list.

**Solution**:
```java
class Node {
    int data;
    Node next, child;
    Node(int d) {
        data = d;
        next = child = null;
    }
}

public class FlattenLinkedList {
    public static Node flattenList(Node head) {
        if (head == null) {
            return head;
        }
        if (head.child != null) {
            Node next = head.next;
            head.next = head.child;
            head.child = null;
            Node temp = head.next;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = next;
        }
        flattenList(head.next);
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.child = new Node(7);
        head.next.child.next = new Node(8);
        head.next.child.child = new Node(11);
        head.next.child.child.next = new Node(12);

        head = flattenList(head);
        printList(head);
    }
}
```

### 32. Calculate Power using Exponentiation by Squaring
**Problem**: Calculate \( x \) raised to the power \( n \) (i.e., \( x^n \)) using exponentiation by squaring.

**Solution**:
```java
public class PowerCalculation {
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        double base = 2;
        int exponent = 10;
        double result = power(base, exponent);
        System.out.println(base + " raised to the power " + exponent + " is " + result);
    }
}
```

### 33. Inorder Traversal of Binary Tree
**Problem**: Perform an inorder traversal of a binary tree.

**Solution**:
```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class InorderTraversal {
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        inorder(root);
    }
}
```

### 34. Generate Gray Code
**Problem**: Generate the Gray code sequence for a given number of bits.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static List<String> generateGrayCode(int n) {
        if (n == 0) {
            List<String> result = new ArrayList<>();
            result.add("0");
            return result;
        }
        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("0");
            result.add("1");
            return result;
        }
        List<String> prevGrayCode = generateGrayCode(n - 1);
        List<String> result = new ArrayList<>();
        for (String code : prevGrayCode) {
            result.add("0" + code);
        }
        for (int i = prevGrayCode.size() - 1; i >= 0; i--) {
            result.add("1" + prevGrayCode.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> grayCode = generateGrayCode(n);
        for (String code : grayCode) {
            System.out.println(code);
        }
    }
}
```

These additional examples provide further illustration of how recursion can be utilized to solve a variety of problems in Java.

Certainly! Here are more recursive problems with solutions in Java:

### 35. Print All Subsequences of a String
**Problem**: Print all subsequences of a given string.

**Solution**:
```java
public class Subsequences {
    public static void printSubsequences(String str, String current, int index) {
        if (index == str.length()) {
            System.out.println(current);
            return;
        }
        printSubsequences(str, current + str.charAt(index), index + 1);
        printSubsequences(str, current, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences(str, "", 0);
    }
}
```

### 36. Sum of Digits of a Number
**Problem**: Calculate the sum of the digits of a number.

**Solution**:
```java
public class SumOfDigits {
    public static int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        int number = 12345;
        int sum = sumDigits(number);
        System.out.println("Sum of digits: " + sum);
    }
}
```

### 37. Count Vowels in a String
**Problem**: Count the number of vowels in a string.

**Solution**:
```java
public class CountVowels {
    public static int countVowels(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        char c = str.charAt(index);
        int count = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                     c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') ? 1 : 0;
        return count + countVowels(str, index + 1);
    }

    public static void main(String[] args) {
        String str = "hello world";
        int vowelCount = countVowels(str, 0);
        System.out.println("Number of vowels: " + vowelCount);
    }
}
```

### 38. Tower of Hanoi
**Problem**: Solve the Tower of Hanoi puzzle.

**Solution**:
```java
public class TowerOfHanoi {
    public static void solveHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        solveHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        solveHanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        solveHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}
```

### 39. Find Minimum Element in an Array
**Problem**: Find the minimum element in an array.

**Solution**:
```java
public class MinElement {
    public static int findMin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 45, 6, 10, -8};
        int min = findMin(array, array.length);
        System.out.println("Minimum element in the array is: " + min);
    }
}
```

### 40. Generate All Balanced Parentheses
**Problem**: Generate all combinations of balanced parentheses given n pairs.

**Solution**:
```java
public class BalancedParentheses {
    public static void generateParentheses(int n, int open, int close, String result) {
        if (open == n && close == n) {
            System.out.println(result);
            return;
        }
        if (open < n) {
            generateParentheses(n, open + 1, close, result + "(");
        }
        if (close < open) {
            generateParentheses(n, open, close + 1, result + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParentheses(n, 0, 0, "");
    }
}
```

### 41. Reverse a String
**Problem**: Reverse a given string.

**Solution**:
```java
public class ReverseString {
    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello";
        String reversed = reverse(str);
        System.out.println("Reversed string: " + reversed);
    }
}
```

### 42. Merge Sort
**Problem**: Implement Merge Sort algorithm.

**Solution**:
```java
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
```

### 43. Fibonacci Sequence
**Problem**: Generate the first n Fibonacci numbers.

**Solution**:
```java
public class Fibonacci {
    public static void printFibonacci(int n, int a, int b) {
        if (n == 0) {
            return;
        }
        System.out.print(a + " ");
        printFibonacci(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacci(n, 0, 1);
    }
}
```

### 44. Palindrome Check
**Problem**: Check if a string is a palindrome.

**Solution**:
```java
public class PalindromeCheck {
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        return str.charAt(start) == str.charAt(end) && isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "racecar";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println("Is \"" + str + "\" a palindrome? " + result);
    }
}
```

### 45. Sum of Elements in a List
**Problem**: Calculate the sum of all elements in a list.

**Solution**:
```java
import java.util.List;

public class ListSum {
    public static int sumList(List<Integer> list, int index) {
        if (index == list.size()) {
            return 0;
        }
        return list.get(index) + sumList(list, index + 1);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int sum = sumList(list, 0);
        System.out.println("Sum of list elements: " + sum);
    }
}
```

These examples should further illustrate the power and versatility of recursion in solving a wide range of problems.

Certainly! Here are more questions and solutions for linked lists and binary trees using recursion technique:

### Linked List Problems

#### 1. Merge Two Sorted Linked Lists
**Problem**: Merge two sorted linked lists and return the merged list.

**Solution**:
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode merged = mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
```

#### 2. Remove Duplicates from a Sorted Linked List
**Problem**: Remove duplicates from a sorted linked list.

**Solution**:
```java
public class RemoveDuplicates {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            head.next = head.next.next;
            removeDuplicates(head);
        } else {
            removeDuplicates(head.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        head = removeDuplicates(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
```

#### 3. Reverse a Linked List
**Problem**: Reverse a linked list.

**Solution**:
```java
public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverse(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
```

### Binary Tree Problems

#### 1. Find the Maximum Depth of a Binary Tree
**Problem**: Find the maximum depth of a binary tree.

**Solution**:
```java
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Maximum Depth: " + maxDepth(root));
    }
}
```

#### 2. Symmetric Tree
**Problem**: Check if a binary tree is symmetric (mirror image of itself).

**Solution**:
```java
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is Symmetric: " + isSymmetric(root));
    }
}
```

#### 3. Path Sum
**Problem**: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

**Solution**:
```java
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("Has Path Sum 22: " + hasPathSum(root, 22));
    }
}
```

These examples should provide more insight into solving problems with linked lists and binary trees using recursion in Java.

Certainly! Here are more questions and solutions for linked lists and binary trees using recursion technique:

### Linked List Problems

#### 4. Detect Cycle in a Linked List
**Problem**: Detect if a linked list has a cycle in it.

**Solution**:
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCycle {
    public static boolean hasCycle(ListNode head) {
        return detectCycle(head, head);
    }

    private static boolean detectCycle(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
        return detectCycle(slow, fast);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        System.out.println("Has Cycle: " + hasCycle(head));
    }
}
```

#### 5. Find Middle of Linked List
**Problem**: Find the middle node of a linked list.

**Solution**:
```java
public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        return findMiddle(head, head);
    }

    private static ListNode findMiddle(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return slow;
        }
        return findMiddle(slow.next, fast.next.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = findMiddle(head);
        System.out.println("Middle Node: " + middle.val);
    }
}
```

#### 6. Check Palindrome Linked List
**Problem**: Check if a linked list is a palindrome.

**Solution**:
```java
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode reversed = reverse(cloneList(head));
        return isEqual(head, reversed);
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode cloneList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newNode = new ListNode(head.val);
        newNode.next = cloneList(head.next);
        return newNode;
    }

    private static boolean isEqual(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null || l2 == null || l1.val != l2.val) {
            return false;
        }
        return isEqual(l1.next, l2.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome: " + isPalindrome(head));
    }
}
```

### Binary Tree Problems

#### 4. Invert Binary Tree
**Problem**: Invert a binary tree.

**Solution**:
```java
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root = invertTree(root);
        System.out.println("Inverted Tree Root: " + root.val);
    }
}
```

#### 5. Convert Sorted Array to Binary Search Tree
**Problem**: Convert a sorted array to a height-balanced binary search tree.

**Solution**:
```java
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println("BST Root: " + root.val);
    }
}
```

#### 6. Lowest Common Ancestor of a Binary Tree
**Problem**: Find the lowest common ancestor of two nodes in a binary tree.

**Solution**:
```java
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}
```

These examples provide further practice and insights into solving problems with linked lists and binary trees using recursion in Java.

Sure, here are more questions and solutions for linked lists and binary trees using recursion techniques in Java:

### Linked List Problems

#### 7. Swap Nodes in Pairs
**Problem**: Given a linked list, swap every two adjacent nodes and return its head.

**Solution**:
```java
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode swapped = swapPairs(head);
        while (swapped != null) {
            System.out.print(swapped.val + " ");
            swapped = swapped.next;
        }
    }
}
```

#### 8. Remove Nth Node From End of List
**Problem**: Given a linked list, remove the nth node from the end of the list and return its head.

**Solution**:
```java
public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        if (n > length) return head;

        if (n == length) {
            return head.next;
        }

        head.next = removeNthFromEnd(head.next, n);
        return head;
    }

    private static int getLength(ListNode head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode newHead = removeNthFromEnd(head, n);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
```

#### 9. Merge K Sorted Linked Lists
**Problem**: Merge k sorted linked lists and return it as one sorted list.

**Solution**:
```java
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode merged = mergeKLists(lists);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
```

### Binary Tree Problems

#### 7. Serialize and Deserialize Binary Tree
**Problem**: Design an algorithm to serialize and deserialize a binary tree.

**Solution**:
```java
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "null,";
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        return root.val + "," + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(List.of(data.split(",")));
        return deserializeHelper(nodes);
    }

    private static TreeNode deserializeHelper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized Tree Root: " + deserialized.val);
    }
}
```

#### 8. Flatten Binary Tree to Linked List
**Problem**: Flatten a binary tree to a linked list in place.

**Solution**:
```java
public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
```

#### 9. Count Univalue Subtrees
**Problem**: Count the number of uni-value subtrees.

**Solution**:
```java
public class CountUnivalueSubtrees {
    public static int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        isUnivalSubtree(root, count);
        return count[0];
    }

    private static boolean isUnivalSubtree(TreeNode node, int[] count) {
        if (node == null) return true;

        boolean left = isUnivalSubtree(node.left, count);
        boolean right = isUnivalSubtree(node.right, count);

        if (left && right) {
            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println("Count of Univalue Subtrees: " + countUnivalSubtrees(root));
    }
}
```

These examples provide further practice and insights into solving problems with linked lists and binary trees using recursion in Java.

Sure! Here are more questions and solutions for linked lists and binary trees using recursion techniques in Java:

### Linked List Problems

#### 10. Rotate List
**Problem**: Given a linked list, rotate the list to the right by k places, where k is non-negative.

**Solution**:
```java
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = getLength(head);
        k = k % length;

        if (k == 0) return head;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    private static int getLength(ListNode head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode rotated = rotateRight(head, k);
        while (rotated != null) {
            System.out.print(rotated.val + " ");
            rotated = rotated.next;
        }
    }
}
```

#### 11. Partition List
**Problem**: Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

**Solution**:
```java
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;
        ListNode partitioned = partition(head, x);
        while (partitioned != null) {
            System.out.print(partitioned.val + " ");
            partitioned = partitioned.next;
        }
    }
}
```

### Binary Tree Problems

#### 10. Validate Binary Search Tree
**Problem**: Given a binary tree, determine if it is a valid binary search tree (BST).

**Solution**:
```java
public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Is Valid BST: " + isValidBST(root));
    }
}
```

#### 11. Binary Tree Maximum Path Sum
**Problem**: Given a non-empty binary tree, find the maximum path sum.

**Solution**:
```java
public class MaxPathSum {
    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        calculateSum(root);
        return maxSum;
    }

    private static int calculateSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, calculateSum(node.left));
        int right = Math.max(0, calculateSum(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Path Sum: " + maxPathSum(root));
    }
}
```

#### 12. Binary Tree Right Side View
**Problem**: Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private static void rightSideView(TreeNode current, List<Integer> result, int depth) {
        if (current == null) return;
        if (depth == result.size()) result.add(current.val);
        rightSideView(current.right, result, depth + 1);
        rightSideView(current.left, result, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println("Right Side View: " + rightSideView(root));
    }
}
```

These additional problems and solutions should help deepen your understanding of recursion techniques in linked lists and binary trees using Java.

Sure! Here are more advanced questions and solutions involving recursion techniques for linked lists and binary trees in Java:

### Linked List Problems

#### 12. Reorder List
**Problem**: Given a singly linked list, reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

**Solution**:
```java
public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        slow.next = null;

        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
```

#### 13. Add Two Numbers II
**Problem**: Given two non-empty linked lists representing two non-negative integers, add the two numbers and return it as a linked list.

**Solution**:
```java
public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        ListNode result = new ListNode(0);
        result.next = addTwoNumbersHelper(l1, l2, len1, len2);
        
        if (result.next.val > 9) {
            result.next.val %= 10;
            result.val = 1;
        }

        return result.val == 0 ? result.next : result;
    }

    private static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int len1, int len2) {
        if (l1 == null && l2 == null) return null;

        int sum = 0;
        ListNode nextNode;
        if (len1 > len2) {
            nextNode = addTwoNumbersHelper(l1.next, l2, len1 - 1, len2);
            sum = l1.val;
        } else if (len1 < len2) {
            nextNode = addTwoNumbersHelper(l1, l2.next, len1, len2 - 1);
            sum = l2.val;
        } else {
            nextNode = addTwoNumbersHelper(l1.next, l2.next, len1 - 1, len2 - 1);
            sum = l1.val + l2.val;
        }

        if (nextNode != null && nextNode.val > 9) {
            sum++;
            nextNode.val %= 10;
        }

        ListNode currentNode = new ListNode(sum);
        currentNode.next = nextNode;
        return currentNode;
    }

    private static int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

### Binary Tree Problems

#### 13. Path Sum II
**Problem**: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, sum, new ArrayList<>(), paths);
        return paths;
    }

    private static void findPaths(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) return;

        currentPath.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            findPaths(node.left, sum - node.val, currentPath, paths);
            findPaths(node.right, sum - node.val, currentPath, paths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int sum = 22;
        List<List<Integer>> result = pathSum(root, sum);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
```

#### 14. Sum of Left Leaves
**Problem**: Find the sum of all left leaves in a given binary tree.

**Solution**:
```java
public class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private static int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null && isLeft) return node.val;
        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Sum of Left Leaves: " + sumOfLeftLeaves(root));
    }
}
```

#### 15. Construct Binary Tree from Inorder and Postorder Traversal
**Problem**: Given inorder and postorder traversal of a tree, construct the binary tree.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPostorder {
    private static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postIndex) {
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postIndex]);
        int inIndex = inorderMap.get(root.val);

        root.right = buildTreeHelper(inorder, postorder, inIndex + 1, inEnd, postIndex - 1);
        root.left = buildTreeHelper(inorder, postorder, inStart, inIndex - 1, postIndex - (inEnd - inIndex) - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);
        System.out.println("Root: " + root.val); // Should print 3
    }
}
```

These additional problems and solutions should provide further practice and insights into solving advanced problems with linked lists and binary trees using recursion in Java.

Certainly! Here are additional advanced questions and solutions involving recursion techniques for linked lists and binary trees in Java:

### Linked List Problems

#### 14. Swap Nodes in Pairs
**Problem**: Given a linked list, swap every two adjacent nodes and return its head.

**Solution**:
```java
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = swapPairs(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

#### 15. Reverse Nodes in k-Group
**Problem**: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

**Solution**:
```java
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy, next = dummy, prev = dummy;
        int count = 0;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        while (count >= k) {
            current = prev.next;
            next = current.next;
            for (int i = 1; i < k; ++i) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            prev = current;
            count -= k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseKGroup(head, 3);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

### Binary Tree Problems

#### 16. Flatten Binary Tree to Linked List
**Problem**: Given a binary tree, flatten it to a linked list in-place.

**Solution**:
```java
public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
```

#### 17. Lowest Common Ancestor of a Binary Tree
**Problem**: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

**Solution**:
```java
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;  // Node 5
        TreeNode q = root.left.right.right;  // Node 4

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA: " + lca.val);  // Should print 5
    }
}
```

#### 18. Serialize and Deserialize Binary Tree
**Problem**: Design an algorithm to serialize and deserialize a binary tree.

**Solution**:
```java
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public static String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        for (String node : data.split(",")) {
            nodes.add(node);
        }
        return deserialize(nodes);
    }

    private static TreeNode deserialize(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized: " + serialize(deserialized));
    }
}
```

#### 19. Convert Sorted Array to Binary Search Tree
**Problem**: Given an integer array with elements sorted in ascending order, convert it to a height-balanced binary search tree (BST).

**Solution**:
```java
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println("Root: " + root.val);  // Should print 0
    }
}
```

#### 20. Convert BST to Greater Tree
**Problem**: Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

**Solution**:
```java
public class BSTToGreaterTree {
    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        TreeNode greaterTree = convertBST(root);
        System.out.println("Root: " + greaterTree.val);  // Should print 18
    }
}
```

These additional problems and solutions should provide even more practice and insights into solving complex problems with linked lists and binary trees using recursion in Java.

Sure! Here are more advanced questions and solutions involving recursion techniques for linked lists and binary trees in Java:

### Linked List Problems

#### 16. Remove N-th Node From End of List
**Problem**: Given a linked list, remove the n-th node from the end of list and return its head.

**Solution**:
```java
public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

#### 17. Rotate List
**Problem**: Given a linked list, rotate the list to the right by k places, where k is non-negative.

**Solution**:
```java
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        tail.next = head;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }

        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = rotateRight(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

### Binary Tree Problems

#### 21. Binary Tree Maximum Path Sum
**Problem**: Given a non-empty binary tree, find the maximum path sum. The path may start and end at any node in the tree.

**Solution**:
```java
public class BinaryTreeMaximumPathSum {
    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private static int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println("Max Path Sum: " + maxPathSum(root));  // Should print 6
    }
}
```

#### 22. Construct Binary Tree from Preorder and Inorder Traversal
**Problem**: Given preorder and inorder traversal of a tree, construct the binary tree.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderAndInorder {
    private static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inorderMap.get(root.val);
        int leftTreeSize = inIndex - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, inIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root: " + root.val);  // Should print 3
    }
}
```

#### 23. Convert Sorted List to Binary Search Tree
**Problem**: Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

**Solution**:
```java
public class SortedListToBST {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBSTHelper(head, null);
    }

    private static TreeNode sortedListToBSTHelper(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBSTHelper(head, slow);
        root.right = sortedListToBSTHelper(slow.next, tail);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        System.out.println("Root: " + root.val);  // Should print 0
    }
}
```

#### 24. Validate Binary Search Tree
**Problem**: Given a binary tree, determine if it is a valid binary search tree (BST).

**Solution**:
```java
public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return isValidBSTHelper(node.left, lower, node.val) && isValidBSTHelper(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Is Valid BST: " + isValidBST(root));  // Should print true
    }
}
```

These additional problems and solutions should provide further practice and insights into solving advanced problems with linked lists and binary trees using recursion in Java.

Sure, here are more advanced problems and solutions involving recursion techniques for linked lists and binary trees in Java:

### Linked List Problems

#### 18. Reverse Nodes in Even Length Groups
**Problem**: Given a linked list, reverse the nodes of each group where the group's length is even, and return its modified list.

**Solution**:
```java
public class ReverseEvenLengthGroups {
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode start = head;

        int groupSize = 1;
        while (start != null) {
            ListNode end = start;
            for (int i = 1; i < groupSize && end.next != null; i++) {
                end = end.next;
            }
            ListNode nextGroup = end.next;
            if (groupSize % 2 == 0) {
                prev.next = reverse(start, nextGroup);
            } else {
                prev = start;
            }
            start.next = nextGroup;
            prev = start;
            start = nextGroup;
            groupSize++;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;
        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode result = reverseEvenLengthGroups(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

#### 19. Merge Two Sorted Lists
**Problem**: Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

**Solution**:
```java
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
```

### Binary Tree Problems

#### 25. Path Sum II
**Problem**: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

**Solution**:
```java
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, sum, new ArrayList<>(), result);
        return result;
    }

    private static void findPaths(TreeNode node, int sum, List<Integer> current, List<List<Integer>> result) {
        if (node == null) return;
        current.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<>(current));
        } else {
            findPaths(node.left, sum - node.val, current, result);
            findPaths(node.right, sum - node.val, current, result);
        }
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = pathSum(root, 22);
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
```

#### 26. Diameter of Binary Tree
**Problem**: Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree.

**Solution**:
```java
public class DiameterOfBinaryTree {
    private static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private static int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter: " + diameterOfBinaryTree(root));  // Should print 3
    }
}
```

#### 27. Construct Binary Tree from Inorder and Postorder Traversal
**Problem**: Given inorder and postorder traversal of a tree, construct the binary tree.

**Solution**:
```java
import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPostorder {
    private static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inorderMap.get(root.val);
        int leftTreeSize = inIndex - inStart;

        root.left = buildTreeHelper(postorder, postStart, postStart + leftTreeSize - 1, inStart, inIndex - 1);
        root.right = buildTreeHelper(postorder, postStart + leftTreeSize, postEnd - 1, inIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);
        System.out.println("Root: " + root.val);  // Should print 3
    }
}
```

#### 28. Invert Binary Tree
**Problem**: Invert a binary tree.

**Solution**:
```java
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = invertTree(root);
        printTree(invertedRoot);
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
```

These additional problems and solutions should provide further practice and insights into solving advanced problems with linked lists and binary trees using recursion in Java.

