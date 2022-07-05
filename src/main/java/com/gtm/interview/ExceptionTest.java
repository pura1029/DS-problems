package com.gtm.interview;

public class ExceptionTest  {
	static int a=10;
	static int b=2;
	private static int divide(){
		int c=0;
        if (a==0 && b==0) {
			throw new ArithmeticException();
		}
        c=a/b;
        return c;
	}
	public static void main(String[] args) {
		int c= ExceptionTest.divide();
		System.out.println("DIvide:"+c);
	}
}
