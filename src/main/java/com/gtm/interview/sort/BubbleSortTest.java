package com.gtm.interview.sort;

public class BubbleSortTest {

	void sort(int arr[]){
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}

		}
	}

	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		BubbleSortTest ob = new BubbleSortTest();
		int arr[] = {64,25,12,22,11};
		ob.sort(arr);
		System.out.println("Sorted array");
		printArray(arr);

	}

}
