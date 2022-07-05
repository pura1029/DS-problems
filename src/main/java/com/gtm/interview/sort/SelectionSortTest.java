package com.gtm.interview.sort;

public class SelectionSortTest {


	void sort(int arr[]){
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int min_i = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] < arr[min_i]) {
					min_i = j;
				}
			}
			int temp = arr[min_i];
			arr[min_i] = arr[i];
			arr[i] = temp;
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

		SelectionSortTest ob = new SelectionSortTest();
		int arr[] = {64,25,12,22,11};
		ob.sort(arr);
		System.out.println("Sorted array");
		printArray(arr);
	}
}
