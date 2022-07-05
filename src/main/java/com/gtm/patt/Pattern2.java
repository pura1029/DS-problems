package com.gtm.patt;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 7;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
