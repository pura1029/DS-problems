package com.gtm.interview;

public class FibonacciUsingRecu {

	public  void fibonacciSeries(int number) {
		System.out.printf("\nFibonacci series in Java of number %s using recursion %n", number);
		for (int i = 0; i < number; i++) {
			System.out.printf("%s ", fabRec(i));
		}

	}

	public int fabRec(int n){
		if (n == 0)
			return 0;
		if (n == 1 || n == 2) {
			return 1;
		}
		int fab1 = fabRec(n-1);
		int fab2 = fabRec(n-2);
		return  (fab1 + fab2) ;
	}

	public static void main(String[] args) {
		FibonacciUsingRecu fr = new FibonacciUsingRecu();
		fr.fibonacciSeries(5);

	}

}
