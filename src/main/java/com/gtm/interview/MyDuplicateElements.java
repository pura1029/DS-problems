package com.gtm.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class MyDuplicateElements {

	public static int[] removeDuplicates(int[] input){
		int j = 0;
		int i = 1;
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			}else{
				input[++j] = input[i++];
			}
		}

		int[] output = Arrays.copyOf(input, j+1);
		return output;
	}

	public static int[] removeDuplicatesUsingList(int[] input){
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : input) {
			if (!list.contains(i)) {
				list.add(i);
			}
		}

		int[] output = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			output[i] = list.get(i);
		}

		return output;

	}


	public static void main(String[] args) {
		int[] input1 = {2,3,6,6,8,9,10,10,10,12,12};
		int[] output = removeDuplicates(input1);
		for(int i:output){
			System.out.print(i+" ");
		}

		System.out.println();
		int[] output1 = removeDuplicatesUsingList(input1);
		for(int i:output1){
			System.out.print(i+" ");
		}
	}

}
