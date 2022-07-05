package com.gtm.patt;

public class Pattern10 {

	public static void main(String[] args) {
		int rows = 7;
		for (int i = 1; i <= rows ; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j+" ") ;
			}
			System.out.println();
		}

	}

}
