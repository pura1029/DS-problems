package com.gtm.ds.sorting;

public class SelectionSort {

	void sort(int arr[]){
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {

			int min_index = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] < arr[min_index]) {
					min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp; 

		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		int arr[] = new int[]{23,45,12,43,76,34};
		ss.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
