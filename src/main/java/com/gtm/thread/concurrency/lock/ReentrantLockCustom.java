/**
 * 
 */
package com.gtm.thread.concurrency.lock;

/**
 * @author kumarga
 *
 */
public class ReentrantLockCustom implements LockCustom {

	int lockHoldCount;

	// Id of thread which is currently holding the lock.
	long idOfThreadCurrentlyHoldingLock;

	/**
	 * Creates an instance of ReentrantLock. Initially lock hold count is 0.
	 */
	ReentrantLockCustom() {
		lockHoldCount = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gtm.thread.concurrency.lock.LockCustom#lock() Acquires the lock if
	 * it is not held by another thread. And sets lock hold count to 1. If current
	 * thread already holds lock then lock hold count is increased by 1. If the lock
	 * is held by another thread then the current thread waits for another thread to
	 * release lock.
	 */
	@Override
	public synchronized void lock() {
		if (lockHoldCount == 0) {
			lockHoldCount++;
			idOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
		} else if (lockHoldCount > 0 && idOfThreadCurrentlyHoldingLock == Thread.currentThread().getId()) {
			lockHoldCount++;
		} else {
			try {
				while (lockHoldCount > 0) {
					System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for lock..");
					wait();
				}
				lockHoldCount++;
				idOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gtm.thread.concurrency.lock.LockCustom#unlock() If the current
	 * thread is the holding the lock then the lock hold count is decremented by 1.
	 * If the lock hold count has reached 0, then the lock is released. If lock hold
	 * count is still greater than 0 then lock is not released. If the current
	 * thread is not holding the lock then IllegalMonitorStateException is thrown.
	 */
	@Override
	public synchronized void unlock() {
		if (lockHoldCount == 0)
			throw new IllegalMonitorStateException("Current Thread is not holding the lock");

		lockHoldCount--;
		if (lockHoldCount == 0) {
			notifyAll();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gtm.thread.concurrency.lock.LockCustom#tryLock() Acquires the lock
	 * if it is not held by another thread and returns true. And sets lock hold
	 * count to 1. If current thread already holds lock then method returns true.
	 * And increments lock hold count by 1. If lock is held by another thread then
	 * method return false.
	 */
	@Override
	public synchronized boolean tryLock() {
		if (lockHoldCount == 0) {
			lock();
			return true;
		} else
			return false;
	}

}
