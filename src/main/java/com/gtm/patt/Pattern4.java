package com.gtm.patt;

public class Pattern4 {

	public static void main(String[] args) {
		int rows = 7;
		for (int i = rows; i >=1 ; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}

	}

}
