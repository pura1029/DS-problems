package com.gtm.patt;

public class Pattern8 {

	public static void main(String[] args) {
		int rows = 7;
		for (int i = rows; i > 0 ; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		for (int i = 1; i < rows ; i++) {
			for (int j = 1; j <= i+1; j++) {
				System.out.print(j+" ") ;
			}
			System.out.println();
		}

	}

}
