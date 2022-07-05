package com.gtm.patt;

public class Pattern12 {

	public static void main(String[] args) {
		int rows = 7;
		for (int i = 1; i <= rows ; i++) {
			for (int j = 1; j <= i; j++) {
				if (j % 2 == 0) 
					System.out.print("0 ") ;	
				else
					System.out.print("1 ") ;
			}
			System.out.println();
		}
	}
}
