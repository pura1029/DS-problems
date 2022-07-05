package com.gtm.array;

public class CircularArrPrint {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int count=4;
		for(int i=count,k=0;i<arr.length+count;i++){
			if(i<arr.length)
				System.out.print(+arr[i]+" ");
			if(i>=arr.length){
				System.out.print(arr[k++]+" ");
			}
		}
		
		System.out.println();

		for (int i = count; i < arr.length+count; i++) {
			System.out.print(arr[i % arr.length]+" ");
		}
	}

}
