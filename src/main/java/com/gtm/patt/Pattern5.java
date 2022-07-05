package com.gtm.patt;

public class Pattern5 {

	public static void main(String[] args) {
		int rows = 7;
		for (int i = 1; i <= rows ; i++) {
			for (int j = rows; j >=i; j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
