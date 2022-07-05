package com.gtm.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatternEx2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a No:");
		int no = Integer.valueOf(br.readLine());
		
		for (int i = 1; i <= no; i++) {
			for (int j = no; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			/*for (int j = 1; j < i; j++) {
				System.out.print(j);
			}*/
			for (int j = i-1; j >= 1; j--) {
				System.out.print(j);
			}
			System.out.println("\n");
		}
	}
}
