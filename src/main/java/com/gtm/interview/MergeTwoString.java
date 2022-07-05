package com.gtm.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoString {

	static String mergeStrings(String a, String b) {
		char [] charA = a.toCharArray();
		char [] charB = b.toCharArray();
		StringBuilder buil = new StringBuilder();
		int aLen = charA.length;
		int bLen = charB.length;
		int fLen = 0;
		boolean isA = true;
		if (aLen >= bLen){
			fLen = aLen;

		}else{
			fLen = bLen;
			isA = false; 
		}
		for(int i=0 ; i < fLen; i++){
			if(isA){
				buil.append(charA[i]);
				if(charB.length > (i)){
					buil.append(charB[i]);
				}
			}else{

				if(charA.length > (i)){
					buil.append(charA[i]);
				} 
				buil.append(charB[i]);
			}

		}
		return buil.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter first String");
		String fString = bf.readLine();
		System.out.println("Enter second String");
		String sString = bf.readLine();
		String mergeStr =  mergeStrings(fString, sString);
		System.out.println("Merge String :"+mergeStr);

	}

}
