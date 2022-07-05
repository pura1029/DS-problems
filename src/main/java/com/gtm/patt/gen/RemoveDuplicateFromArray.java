package com.gtm.patt.gen;

import java.util.Arrays;

public class RemoveDuplicateFromArray {

	public void removeDuplicate(int dupArr[]){
		int totalLen = dupArr.length;

		for (int i = 0; i < totalLen; i++) {
			for (int j = i+1; j < totalLen; j++) {
				if (dupArr[i] == dupArr[j]) {
					dupArr[j] = dupArr[totalLen-1];
					totalLen--;
					j--;
				}
			}
		}
		int withoutDupArr[] = Arrays.copyOf(dupArr, totalLen);
		System.out.println("Array Without Duplicates : ");

		for (int i = 0; i < withoutDupArr.length; i++)
		{
			System.out.print(withoutDupArr[i]+"\t");
		}
	}

	public static void main(String[] args) {
		RemoveDuplicateFromArray rDuplicateFromArray = new RemoveDuplicateFromArray();
		int dupArr[] = {2,4,5,2,6,7,5,2,8};
		rDuplicateFromArray.removeDuplicate(dupArr);
	}

}
