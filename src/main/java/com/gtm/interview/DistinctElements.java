/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
public class DistinctElements {

	public static void printDistinctElements(int[] arr){
		//int arr[]=sortArray(arr1);
		for (int i = 0; i < arr.length; i++) {
			boolean isDistinct=false;
			for (int j =0; j < arr.length; j++) {

				if (arr[i]==arr[j] && i!=j) {
					isDistinct=true;
					break;
				}  

			}
			if (!isDistinct) {
				System.out.print(arr[i]+" ");
			}
		}

	}
	public static int[] sortArray(int arr[]){
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[i] > arr[j])
				{
					int a =  arr[i];
					arr[i] = arr[j];
					arr[j] = a;
				}
			}

		}
		return arr;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {5,2,7,2,4,7,8,2,3,3};
		DistinctElements.printDistinctElements(nums);

	}

}
