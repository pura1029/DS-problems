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
				System.out.println("Sleeping for 2 seconds");
				try
				{
					Thread.sleep(2000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});

		Thread thread2 = new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("Second task completed");
			}
		});
		
		thread1.start();
		thread2.start();
		thread1.join();
		
	}

}
