package com.gtm.interview;

import java.util.Scanner;

public class PrimeSum {

	public static void checkPrime(int upto){
		int sum=0;
		int count=0;
		int number=2;
		while (count<upto) {
			if (isPrime(number)) {
				sum=sum+number;
				++count;
			}
			++number;
		}
	   System.out.println("Prime numbers Sum is "+sum+" ,for first "+upto+" Prime Nos.");
	}
	
	public static boolean isPrime(int number){
		for (int i = 2; i <= number/2; i++) {
			if (number % i==0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a No:");
		int no=scanner.nextInt();
		scanner.close();
		checkPrime(no);
	}

}
