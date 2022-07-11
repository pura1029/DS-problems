package com.gtm.thread.concurrency;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueueCustom<T> implements BlockingQueueCustom<T> {

	private volatile List<T> queue;
	private int maxSize; // maximum number of elements queue can hold at a time.

	public LinkedBlockingQueueCustom() {
		this(Integer.MAX_VALUE);
	}

	public LinkedBlockingQueueCustom(int maxSize) {
		this.maxSize = maxSize;
		this.queue = new LinkedList<>();
	}

	/**
	 * Inserts the specified element into this queue only if space is available else
	 * waits for space to become available. After inserting element it notifies all
	 * waiting threads.
	 */

	@Override
	public synchronized void put(T item) throws InterruptedException {
		while (queue.size() == maxSize) {
			wait();
		}

		queue.add(item);
		this.notifyAll();

	}

	/**
	 * Retrieves and removes the head of this queue only if elements are available
	 * else waits for element to become available. After removing element it
	 * notifies all waiting threads.
	 */
	@Override
	public synchronized T take() throws InterruptedException {
		while (queue.isEmpty()) {
			wait();
		}

		this.notifyAll();
		return queue.remove(0);
	}

	/**
	 * Returns size of LinkedBlockingQueueCustom.
	 */
	@Override
	public synchronized int size() {
		return queue.size();
	}

}
