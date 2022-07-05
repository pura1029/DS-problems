package com.gtm.ds.sorting;

public class BubbleSort {

	void sort(int arr[]){
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {

			for (int j = 0; j < n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;	
				}
			}
			 

		}
	}
	public static void main(String[] args) {
		int arr[] = new int[]{23,45,12,43,76,34};
		BubbleSort bs = new BubbleSort();
		bs.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
