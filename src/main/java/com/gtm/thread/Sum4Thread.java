package com.gtm.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumThread implements Callable<Integer> {
	private Sum sum;
	private int a;
	private int b;

	public SumThread(Sum sum, int a, int b) {
		this.sum = sum;
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return sum.add(a, b);
	}

}

class Sum {
	public int add(int a, int b) {
		return (a + b);
	}
}

public class Sum4Thread {

	public static void main(String[] args) throws Exception {
		Sum sum = new Sum();
		ArrayList<Future<Integer>> list = new ArrayList<>();
		ExecutorService ex = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			list.add(ex.submit(new SumThread(sum, (10 + i), (20 + i))));
		}
		ex.shutdown();
		int s = 0;
		for (Future<Integer> future : list) {
			s += future.get();
		}

		System.out.println("SUM :" + s);
	}

}
