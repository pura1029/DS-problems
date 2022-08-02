/**
 * 
 */
package com.gtm.thread;

/**
 * @author kumarga
 *
 */
public class JoinExample {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("First task started");
				System.out.println("thread1 Sleeping for 2 seconds");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second task started");
				try {
					System.out.println("thread2 Sleeping for 3 seconds");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Second task completed");
			}
		});

		thread1.start();
		thread2.start();
		thread1.join();
		//thread2.join();
		System.out.println("Main task completed");
	}

}
