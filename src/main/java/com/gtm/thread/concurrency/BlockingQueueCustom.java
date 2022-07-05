package com.gtm.thread.concurrency;

public interface BlockingQueueCustom<Type> {

	/**
	 * Inserts the specified element into this queue
	 * only if space is available else
	 * waits for space to become available.
	 */
	void put(Type item)  throws InterruptedException ;


	/**
	 * Retrieves and removes the head of this queue
	 * only if elements are available else
	 * waits for element to become available.
	 */
	Type take()  throws InterruptedException;

	/**
	 * Returns size of queue.
	 */
	int size();
}
