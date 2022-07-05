package com.gtm.thread.concurrency;

public class ThreadPool {

	BlockingQueueCustom<Runnable> taskQueue;
	private boolean isStopped = false;
	public ThreadPool(int nThreads){
		taskQueue = new LinkedBlockingQueueCustom<Runnable>(nThreads);

		//Create and start nThreads number of threads.
		for(int i=1; i<=nThreads; i++){
			ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
			threadPoolsThread.setName("Thread-"+i);
			System.out.println("Thread-"+i +" created in ThreadPool.");
			threadPoolsThread.start();   //start thread
		}

	}

	public synchronized void  execute(Runnable task) throws Exception{
		if(this.isShutdown()) throw
		new IllegalStateException("ThreadPool has been shutDown, no further tasks can be added");

		this.taskQueue.put(task);
	}

	public synchronized void shutdown(){
		this.isStopped = true;
		System.out.println("ThreadPool SHUTDOWN initiated.");
	}

	public synchronized boolean isShutdown(){
		return this.isStopped;
	}
}
