package com.gtm.ds.inttest;

class Person {
	int t = 0;

	public void talk() {
		System.out.print("I am a Person");
	}
}

class Student extends Person {
	int t = 1;

	public void talk() {
		System.out.print("I am a Student");
	}
}

public class InheritanceTest {
	public static void main(String args[]) {
		Person p = new Student();
		p.talk();
		System.out.println("\t" + p.t);
	}
}