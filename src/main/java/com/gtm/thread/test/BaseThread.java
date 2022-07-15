package com.gtm.thread.test;

public abstract class BaseThread {

	private final Thread thread;

	public BaseThread() {
		this(new BaseThreadRunnable());
	}

	private BaseThread(BaseThreadRunnable runnable) {
		this.thread = new Thread(runnable);
		runnable.baseThread = this;
	}

	public void start() {
		System.out.println("BaseThread");
		thread.start();
	}

	public String getName() {
		return thread.getName();
	}

	public void setName(String name) {
		thread.setName(name);
	}

	public void interrupt() {
		thread.interrupt();
	}

	public boolean isAlive() {
		return thread.isAlive();
	}

	public abstract void run();

	private static class BaseThreadRunnable implements Runnable {

		private BaseThread baseThread;

		@Override
		public void run() {
			assert baseThread != null;
			System.out.println("BaseThreadRunnable");
			try {
				baseThread.run();
			} catch (Throwable t) {
				System.err.println(t);
			}
		}

	}
}
