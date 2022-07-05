package com.gtm.java.statictest;

public class BTest {

	public void print() {
		System.out.println(ATest.getAtest().hashCode());
		ATest.getAtest().add(1);
		ATest.getAtest().add(2);
		ATest.getAtest().print();
	}

	public static void main(String[] args) {
		BTest bTest = new BTest();
		bTest.print();

		BTest bTest2 = new BTest();
		bTest2.print();
	}

}
