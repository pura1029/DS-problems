package com.gtm.ds.queue;

public class QueueTest {

	static class QueueUsingArray {
		private int[] arr;
		private int size;
		private int rear = -1;

		QueueUsingArray(int n) {
			size = n;
			arr = new int[size];
		}

		public boolean isEmpty() {
			return rear == -1;
		}

		// enqueue
		public void add(int data) {
			if (rear == size - 1) {
				System.out.println("Full queue");
				return;
			}

			rear++;
			arr[rear] = data;
		}

		public int remove() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}
			int front = arr[0];
			int i = 0;
			for (; i < rear; i++) {
				arr[i] = arr[i + 1];
			}
			arr[i + 1] = 0;
			rear--;
			return front;
		}

		public int peek() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}

			return arr[0];
		}
	}

	public static void main(String[] args) {
		System.out.println("===============Queue using Array==============");
		QueueUsingArray queueUsingArray = new QueueUsingArray(5);
		queueUsingArray.add(1);
		queueUsingArray.add(2);
		queueUsingArray.add(3);
		while (!queueUsingArray.isEmpty()) {
			System.out.println(queueUsingArray.peek());
			queueUsingArray.remove();
		}
	}

}
