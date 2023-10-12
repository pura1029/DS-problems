package com.gtm.ds.heap;

public class HeapTest {

    static int insertNode(int[] arr, int n, int key) {
        n = n + 1;
        arr[n - 1] = key;

        // Heapify the new node following a
        // Bottom-up approach
        heapify(arr, n - 1);

        return n;
    }

    static int insertNode1(int[] arr, int n, int key) {
        n = n + 1;
        int i = n - 1;
        arr[i] = key;

        // Heapify the new node following a
        // Bottom-up approach
        // For Max-Heap
        // If current node is greater than its parent
        // Swap both of them and call heapify again
        // for the parent
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (arr[parent] < arr[i]) {
                swap(arr, i, parent);
                i = parent;
            } else {
                return n;
            }
        }

        return n;
    }

    /**
     * Heapify the new node following a Bottom-up approach
     *
     * @param arr
     * @param i
     */
    private static void heapify(int[] arr, int i) {
        // Find parent
        int parent = (i - 1) / 2;

        // For Max-Heap
        // If current node is greater than its parent
        // Swap both of them and call heapify again
        // for the parent
        if (parent >= 0 && arr[i] > arr[parent]) {
            swap(arr, i, parent);

            // Recursively heapify the parent node
            heapify(arr, parent);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i] + " ");

        System.out.println();
    }

    static int deleteRoot(int arr[], int n) {
        int lastElement = arr[n - 1];

        // Replace root with first element
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapifyForDelete(arr, n, 0);

        // return new size of Heap
        return n;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[].and n is size of heap
    static void heapifyForDelete(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapifyForDelete(arr, n, largest);
        }
    }

    static int deleteNode(int arr[], int n) {
        int lastElement = arr[n - 1];

        // Replace root with first element
        arr[0] = lastElement;

        // Top-Bottom approach
        // Decrease size of heap by 1
        // For Max-Heap
        // If current node is less than its parent
        // Swap both of them and call heapify again
        // for the larger
        n = n - 1;
        int i = 0;
        while (i < n) {
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2
            int larger = arr[l] > arr[r] ? l : r;
            if (arr[i] < arr[larger]) {
                swap(arr, i, larger);
                i = larger;
            } else {
                return n;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int MAX = 1000;
        int[] arr = new int[MAX];

        // initializing some values
        arr[0] = 10;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 4;
        int key = 15;
        int n = 5;

        n = insertNode(arr, n, key);
        printArray(arr, n);
        // Final Heap will be:
        // 15
        // / \
        // 5 10
        // / \ /
        // 2 4 3

        n = deleteRoot(arr, n);

        printArray(arr, n);

        // Final Heap will be:
        // 10
        // / \
        // 5 3
        // / \
        // 2 4
    }

}
