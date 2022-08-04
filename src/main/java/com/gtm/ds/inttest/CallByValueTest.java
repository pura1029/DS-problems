package com.gtm.ds.inttest;

public class CallByValueTest {
	int data = 0;

	public static void main(String[] args) {
		CallByValueTest sample = new CallByValueTest();
		sample.data = 10;
		sample.change(sample);
		System.out.println(sample.data);
	}

	public void change(CallByValueTest sample) {
		sample.data = 20;
		sample = new CallByValueTest();
	}
}