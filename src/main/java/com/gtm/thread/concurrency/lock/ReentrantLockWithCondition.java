package com.gtm.thread.concurrency.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
//https://www.baeldung.com/java-concurrent-locks
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition {
	Queue<String> queue = new LinkedList<>();
	int capacity = 5;
	ReentrantLock lock = new ReentrantLock();
	Condition stackEmptyCondition = lock.newCondition();
	Condition stackFullCondition = lock.newCondition();

	public void pushToStack(String item) {
		try {
			lock.lock();
			while (queue.size() == capacity) {
				System.out.println("Push Thread name :" + Thread.currentThread().getName() + " waiting..");
				stackFullCondition.await();
			}
			queue.add(item);
			stackEmptyCondition.signalAll();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			lock.unlock();
		}
	}

	public String popFromStack() {

		try {
			lock.lock();
			while (queue.isEmpty()) {
				System.out.println("Pop Thread name :" + Thread.currentThread().getName() + " waiting..");
				stackEmptyCondition.await();
			}
			return queue.poll();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			stackFullCondition.signalAll();
			lock.unlock();
		}
		return null;
	}

	public static void main(String[] args) {
		ReentrantLockWithCondition lockTest = new ReentrantLockWithCondition();
		
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				Integer val = new Random().nextInt(100);
				System.out.println("Push Thread name :" + Thread.currentThread().getName() + "=" + val);
				lockTest.pushToStack("" + val);
			}

		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(
						"Pop Thread name :" + Thread.currentThread().getName() + "=" + lockTest.popFromStack());
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main thread done :" + Thread.currentThread().getName());
	}
}
