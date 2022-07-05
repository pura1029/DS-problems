package com.gtm.inheritance;

public class B extends A {

	public static void show(){
		System.out.println("B show()");
	}
	
	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		a.show();
		b.show();
	}
}
