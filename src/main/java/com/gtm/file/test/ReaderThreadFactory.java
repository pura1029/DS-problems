/*
 * 
 */
package com.gtm.file.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadFactory;


/**
 * A factory for creating ReaderThread objects.
 */
public class ReaderThreadFactory implements ThreadFactory {

	/** The threads. */
	private Set<Thread> threads;
	
	/** The thread group. */
	private ThreadGroup threadGroup;

	/**
	 * Instantiates a new reader thread factory.
	 */
	public ReaderThreadFactory() {
		this.threadGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(),
				ReaderThreadFactory.class.getSimpleName());
		threads = new HashSet<Thread>();
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(threadGroup, r, ReaderRunnable.class.getSimpleName() + "-Thread-" + threads.size());
		threads.add(thread);
		return thread;
	}

	/**
	 * Gets the threads.
	 *
	 * @return the threads
	 */
	public Set<Thread> getThreads() {
		return threads;
	}

}
