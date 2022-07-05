package com.gtm.java.statictest;

import java.util.ArrayList;
import java.util.List;

public class ATest {

	private static final ATest aTest = new ATest();

	private List<Integer> list;

	private ATest() {
		list = new ArrayList<>();
	}

	public void add(int data) {
		list.add(data);
	}

	public void print() {
		list.forEach(System.out::println);
	}

	public static ATest getAtest() {
		return aTest;
	}

}
