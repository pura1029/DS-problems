package com.gtm.thread.concurrency.lock;

/**
 * Custom Lock interface
 */
public interface LockCustom {

	void lock();

	void unlock();

	boolean tryLock();
}
