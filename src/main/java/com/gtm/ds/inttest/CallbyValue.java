package com.gtm.ds.inttest;

public class CallbyValue {
	int change(int b) {
		++b; // Changes will be in the local variable only.
		return b;
	}

	public static void main(String[] args) {
// Create an object of class. 
		CallbyValue obj = new CallbyValue();
		int a = 20;
		int x = obj.change(a);
		System.out.println("Value of a after passing: " + a);
		System.out.println("Value of x after modifying: " + x);
	}
}