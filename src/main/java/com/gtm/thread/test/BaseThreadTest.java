package com.gtm.thread.test;

public class BaseThreadTest {

	public static void main(String[] args) {
		TaskTest taskTest = new TaskTest();
		taskTest.setName("TaskTest");
		taskTest.start();

		Thread thread = new Thread(() -> {
			System.out.println("LambdaThreadTest");
			System.out.println("Thread name " + Thread.currentThread().getName());
		});
		thread.start();
	}

}
