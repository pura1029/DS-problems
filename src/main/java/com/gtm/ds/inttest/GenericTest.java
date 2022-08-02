package com.gtm.ds.inttest;

public class GenericTest<T> {

	T data;

	public GenericTest(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public static void main(String[] args) {
		GenericTest<String> genericTest = new GenericTest<>("a");
		GenericTest<Integer> genericTest2 = new GenericTest<>(123);
		System.out.print(genericTest.getData());
		System.out.print(genericTest2.getData());
	}

}
