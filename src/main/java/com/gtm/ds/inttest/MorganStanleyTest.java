package com.gtm.ds.inttest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MorganStanleyTest {

	private class Disp {

	}

	enum Ani {
		ONE, Two;
	}

	static void print(Object a) {
		System.out.println("objj");
	}

	static void print(A a) {
		System.out.println("a");
	}

	static void print(B a) {
		System.out.println("b");
	}

	public static void main(String[] args) {

		C c = new C();
		print(c);

		Ani[] anis = Ani.values();
		System.err.println(anis[0]);

		System.out.println(test());

		Set<? extends IOException> exceptions = new TreeSet<FileNotFoundException>();
		Set<? extends IOException> exceptions2 = new TreeSet<IOException>();
		// Set<? extends IOException> exceptions3 = new TreeSet<Exception>();
		Set<? super IOException> exceptions1 = new TreeSet<Exception>();
		Set<? super IOException> exceptions3 = new TreeSet<IOException>();

		// Set<? super IOException> exceptions4 = new TreeSet<FileNotFoundException>();

		Disp disp = new MorganStanleyTest().new Disp();

		int sum = Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).filter(i -> i % 2 == 0).map(i -> i * 2).sum();

		System.out.println(sum);

	}

	static Object test() {
		try {
			int a = 10 / 0;
			return a;
		} catch (Exception e) {
			return "cat";
		} finally {
			return "fi";
		}
	}
}

class A {

}

class B extends A {

}

class C extends B {

}
