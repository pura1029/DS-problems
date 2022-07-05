package com.gtm.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadPool {

	private static final ExecutorService pool = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				Runnable worker = new WorkerThread("" + i);
				pool.submit(worker);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.shutdown();
			System.out.println("Finished all threads");
		}

	}


}
