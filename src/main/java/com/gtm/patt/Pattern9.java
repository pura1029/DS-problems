package com.gtm.patt;

public class Pattern9 {

	public static void main(String[] args) {
		int rows = 7;
		int val = 1;
		for (int i = 1; i <= rows ; i++) {
			for (int j = 1; j <= 2*i-1; j++) {
				if (j > i){
					val--;
					System.out.print(val+" ") ;
				}
				else{
					System.out.print(j+" ") ;
					val = j;
				}
			}
			System.out.println();
		}
	}

}
