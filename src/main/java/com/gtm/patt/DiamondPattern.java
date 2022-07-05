package com.gtm.patt;

import java.util.Scanner;

public class DiamondPattern {

	public void genDiamond(int no){
		int noOfRow = no/2;
		int row = 1;
		for (int i = noOfRow; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= row; j++) {
				System.out.print("* ");
			}
			System.out.println();
			row ++;
		}
		for (int i = 0; i <= noOfRow; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = row; j >= 1; j--) {
				System.out.print("* ");
			}
			System.out.println();
			row --;
		}
		
		System.out.println("================================");
		row = noOfRow;
		for (int i = 0; i < noOfRow; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= row; j++) {
				System.out.print("* ");
			}
			System.out.println();
			row --;
		}
		row = 1;
		for (int i = noOfRow; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = row; j > 0; j--) {
				System.out.print("* ");
			}
			System.out.println();
			row ++;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a no :");
		int n = scanner.nextInt();
		scanner.close();
		DiamondPattern pattern = new DiamondPattern();
		pattern.genDiamond(n);
	}

}
