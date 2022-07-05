/**
 * 
 */
package com.gtm.volatileEx;

/**
 * @author kumarga
 *
 */
public class ThreadMain extends Thread {

	public ThreadMain() {

	}
	@Override
	public void run() {
		SingletoneWithVolatile volatile1 = SingletoneWithVolatile.getInstance();
		volatile1.dispInstance();

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadMain thread1 = new ThreadMain();
		ThreadMain thread2 = new ThreadMain();
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
