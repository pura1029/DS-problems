package com.gtm.ds.inttest;

// Java Program to Demonstrate Different Return Types
// if Return Type in Overridden method is Sub-type
//https://www.geeksforgeeks.org/covariant-return-types-java/
//https://en.wikipedia.org/wiki/Liskov_substitution_principle
// Class 1
class A1 {
	public void print() {
		System.out.println("A1 class print");
	}
}

// Class 2
class B1 extends A1 {
	@Override
	public void print() {
		System.out.println("B1 class print");
	}
}

// Class 3
// Helper class (Base class)
class Base {

	// Method of this class of class1 return type
	public A1 fun() {
		// Display message only
		System.out.println("Base fun()");

		return new A1();
	}
}

// Class 4
// Helper class extending above class
class Derived extends Base {

	// Method of this class of class1 return type
	@Override
	public B1 fun() {
		// Display message only
		System.out.println("Derived fun()");

		return new B1();
	}
}

// Class 5
// Main class
public class CovariantReturnTypes {

	// Main driver method
	public static void main(String args[]) {

		// Creating object of class3 type
		Base base = new Base();

		// Calling method fun() over this object
		// inside main() method
		base.fun().print();

		// Creating object of class4 type
		Derived derived = new Derived();

		// Again calling method fun() over this object
		// inside main() method
		derived.fun().print();
	}
}
