/**
 * 
 */
package com.gtm.thread;

/**
 * @author kumarga
 *
 */

class Consumer extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
		{
			System.out.println("I am Consumer : Consumed Item " + i);
			Thread.yield();
		}
	}
}

class Producer extends Thread
{
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.println("I am Producer : Produced Item " + i);
			Thread.yield();
		}
	}
}
public class YieldExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread producer = new Producer();
		Thread consumer = new Consumer();

		producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
		consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

		producer.start();
		consumer.start();
	}

}
