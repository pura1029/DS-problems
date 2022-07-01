package com.gtm.ds.arr;

public class QueueTest {

	private static class Queue {
		private int[] arr;
		private int size;
		private int rear;

		Queue(int n) {
			this.size = n;
			this.arr = new int[n];
			this.rear = -1;
		}

		public boolean isEmpty() {
			return (rear == -1);
		}

		public boolean isFull() {
			return ((rear + 1) == size);
		}

		// enqueue
		public void add(int data) {
			if (isFull()) {
				System.out.println("queue full");
				return;
			}

			rear = (rear + 1);

			arr[rear] = data;
		}

		// dequeue
		public int remove() {
			if (isEmpty()) {
				System.out.println("queue empty");
				return -1;
			}

			int res = arr[0];
			for (int i = 0; i < rear; i++) {
				arr[i] = arr[i + 1];
			}
			rear--;
			return res;
		}

		// peek
		public int peek() {
			if (isEmpty()) {
				System.out.println("queue empty");
				return -1;
			}

			return arr[0];
		}
	}

	private static class QueueCircularArray {
		private int[] arr;
		private int size;
		private int rear;
		private int front;

		QueueCircularArray(int n) {
			this.size = n;
			this.arr = new int[n];
			this.rear = -1;
			this.front = -1;
		}

		public boolean isEmpty() {
			return (rear == -1 && front == -1);
		}

		public boolean isFull() {
			return ((rear + 1) % size == front);
		}

		// enqueue
		public void add(int data) {
			if (isFull()) {
				System.out.println("queue full");
				return;
			}
			// 1st element add only
			if (front == -1) {
				front = 0;
			}

			rear = (rear + 1) % size;

			arr[rear] = data;
		}

		// dequeue
		public int remove() {
			if (isEmpty()) {
				System.out.println("queue empty");
				return -1;
			}

			int res = arr[front];
			// 1st element remove only
			if (rear == front) {
				rear = -1;
				front = -1;
			} else {
				front = (front + 1) % size;
			}
			return res;
		}

		// peek
		public int peek() {
			if (isEmpty()) {
				System.out.println("queue empty");
				return -1;
			}

			return arr[front];
		}
	}

	public static void main(String[] args) {
		System.out.println("=========Queue Using Circular Array==========");

		QueueCircularArray queue = new QueueCircularArray(5);

		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println("remove :" + queue.remove());
		queue.add(6);
		System.out.println("remove :" + queue.remove());
		queue.add(7);

		while (!queue.isEmpty()) {
			System.out.println(queue.peek());
			queue.remove();
		}

		System.out.println("=========Queue Using Array==========");

		Queue queue1 = new Queue(5);

		queue1.add(1);
		queue1.add(2);
		queue1.add(3);
		queue1.add(4);
		queue1.add(5);
		System.out.println("remove :" + queue1.remove());
		queue1.add(6);
		System.out.println("remove :" + queue1.remove());
		queue1.add(7);

		while (!queue1.isEmpty()) {
			System.out.println(queue1.peek());
			queue1.remove();
		}
	}

}
