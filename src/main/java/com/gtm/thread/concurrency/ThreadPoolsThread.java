package com.gtm.thread.concurrency;

/**
 * These threads are created and started from constructor of ThreadPool class.
 */
public class ThreadPoolsThread extends Thread {

	private BlockingQueueCustom<Runnable> taskQueue;
	private ThreadPool threadPool;

	public ThreadPoolsThread(BlockingQueueCustom<Runnable> taskQueue, ThreadPool threadPool) {
		super();
		this.taskQueue = taskQueue;
		this.threadPool = threadPool;
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println(Thread.currentThread().getName() + " is READY to execute task.");

				/*
				 * ThreadPool's thread will take() task from sharedQueue only if tasks are
				 * available else waits for tasks to become available.
				 */
				Runnable runnable = taskQueue.take();
				System.out.println(Thread.currentThread().getName() + " has taken task.");
				// Now, execute task with current thread.
				runnable.run();

				System.out.println(Thread.currentThread().getName() + " has EXECUTED task.");

				/*
				 * 1) Check whether pool shutDown has been initiated or not, if pool shutDown
				 * has been initiated and 2) taskQueue does not contain any unExecuted task
				 * (i.e. taskQueue's size is 0 ) than interrupt() the thread.
				 */
				if (this.threadPool.isShutdown() && this.taskQueue.size() == 0) {
					this.interrupt();
					/*
					 * Interrupting basically sends a message to the thread indicating it has been
					 * interrupted but it doesn't cause a thread to stop immediately,
					 * 
					 * if sleep is called, thread immediately throws InterruptedException
					 */
					Thread.sleep(1);
				}
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " has been STOPPED.");
		}
	}
}

/**
 * Task class which implements Runnable.
 */
class Task implements Runnable {
	@Override
	public void run() {
		try {
			// thread is taking 1 sec to perform a task
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is executing task.");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
