package com.gtm.thread.concurrency;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueueCustom<Type> implements BlockingQueueCustom<Type> {

	private List<Type> queue;
	private int  maxSize ; //maximum number of elements queue can hold at a time.

	public LinkedBlockingQueueCustom(){
		this.maxSize = Integer.MAX_VALUE;
		queue = new LinkedList<Type>();
	}
	public LinkedBlockingQueueCustom(int maxSize){
		this.maxSize = maxSize;
		queue = new LinkedList<Type>();
	}


	/**
	 * Inserts the specified element into this queue
	 * only if space is available else
	 * waits for space to become available.
	 * After inserting element it notifies all waiting threads.
	 */

	@Override
	public synchronized void put(Type item) throws InterruptedException {
		if(queue.size() == maxSize)
			wait();

		queue.add(item);
		this.notifyAll();

	}

	/**
	 * Retrieves and removes the head of this queue
	 * only if elements are available else
	 * waits for element to become available.
	 * After removing element it notifies all waiting threads.
	 */
	@Override
	public synchronized  Type take() throws InterruptedException {
		if(queue.size() == 0)
			wait();

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
