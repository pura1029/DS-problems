package com.gtm.ds.queue;

import java.util.Stack;

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

		public boolean isFull() {
			return (rear == size - 1);
		}

		// enqueue
		public void add(int data) {
			if (isFull()) {
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

	static class QueueUsingCirculerArray {
		private int[] arr;
		private int size;
		private int rear = -1;
		private int front = -1;

		QueueUsingCirculerArray(int n) {
			size = n;
			arr = new int[size];
		}

		public boolean isEmpty() {
			return (rear == -1 && front == -1);
		}

		public boolean isFull() {
			return (((rear + 1) % size) == front);
		}

		// enqueue
		public void add(int data) {
			if (isFull()) {
				System.out.println("Full queue");
				return;
			}

			// 1st element add
			if (front == -1) {
				front = 0;
			}

			rear = (rear + 1) % size;
			arr[rear] = data;
		}

		public int remove() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}
			int res = arr[front];

			// single element condition
			if (rear == front) {
				rear = -1;
				front = -1;
			} else {
				front = (front + 1) % size;
			}
			return res;
		}

		public int peek() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}

			return arr[front];
		}
	}

	static class QueueUsingLinkedList {

		private Node head;
		private Node tail;
		private int size;

		class Node {
			private int data;
			private Node next;

			Node(int data) {
				super();
				this.data = data;
				this.next = null;
			}
		}

		QueueUsingLinkedList() {
			this.head = null;
			this.tail = null;
			this.size = -1;
		}

		public boolean isEmpty() {
			return (head == null && tail == null);
		}

		// enqueue
		public void add(int data) {
			Node newNode = new Node(data);
			size++;
			if (tail == null) {
				tail = newNode;
				head = newNode;
				return;
			}

			tail.next = newNode;
			tail = newNode;
		}

		public int remove() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}
			size--;
			int res = head.data;

			// single element condition
			if (head == tail) {
				tail = null;
			}
			head = head.next;
			return res;
		}

		public int peek() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}

			return head.data;
		}

		public int size() {
			return this.size;
		}
	}

	static class QueueUsing2Stacks {

		private Stack<Integer> stack1;
		private Stack<Integer> stack2;

		QueueUsing2Stacks() {
			this.stack1 = new Stack<>();
			this.stack2 = new Stack<>();
		}

		public boolean isEmpty() {
			return stack1.isEmpty();
		}

		// enqueue
		public void add(int data) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			stack1.push(data);

			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		}

		public int remove() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}

			return stack1.pop();
		}

		public int peek() {
			if (isEmpty()) {
				System.out.println("Empty queue");
				return -1;
			}

			return stack1.peek();
		}

		public int size() {
			return stack1.size();
		}
	}

	public static void main(String[] args) {
		System.out.println("===============Queue using Array==============");
		QueueUsingArray queueUsingArray = new QueueUsingArray(5);
		queueUsingArray.add(1);
		queueUsingArray.add(2);
		queueUsingArray.add(3);
		queueUsingArray.add(4);
		queueUsingArray.add(5);
		System.out.println("Remove " + queueUsingArray.remove());
		queueUsingArray.add(6);
		System.out.println("Remove " + queueUsingArray.remove());
		queueUsingArray.add(7);
		while (!queueUsingArray.isEmpty()) {
			System.out.println(queueUsingArray.peek());
			queueUsingArray.remove();
		}

		System.out.println("===============Queue using Circuler Array==============");
		QueueUsingCirculerArray queueUsingCirculerArray = new QueueUsingCirculerArray(5);
		queueUsingCirculerArray.add(1);
		queueUsingCirculerArray.add(2);
		queueUsingCirculerArray.add(3);
		queueUsingCirculerArray.add(4);
		queueUsingCirculerArray.add(5);
		System.out.println("Remove " + queueUsingCirculerArray.remove());
		queueUsingCirculerArray.add(6);
		System.out.println("Remove " + queueUsingCirculerArray.remove());
		queueUsingCirculerArray.add(7);
		while (!queueUsingCirculerArray.isEmpty()) {
			System.out.println(queueUsingCirculerArray.peek());
			queueUsingCirculerArray.remove();
		}

		System.out.println("===============Queue using Linked List==============");
		QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
		queueUsingLinkedList.add(1);
		queueUsingLinkedList.add(2);
		queueUsingLinkedList.add(3);
		queueUsingLinkedList.add(4);
		queueUsingLinkedList.add(5);
		System.out.println("Remove " + queueUsingLinkedList.remove());
		queueUsingLinkedList.add(6);
		System.out.println("Remove " + queueUsingLinkedList.remove());
		queueUsingLinkedList.add(7);
		while (!queueUsingLinkedList.isEmpty()) {
			System.out.println(queueUsingLinkedList.peek());
			queueUsingLinkedList.remove();
		}

		System.out.println("===============Queue using Linked List==============");
		QueueUsing2Stacks queueUsing2Stacks = new QueueUsing2Stacks();
		queueUsing2Stacks.add(1);
		queueUsing2Stacks.add(2);
		queueUsing2Stacks.add(3);
		queueUsing2Stacks.add(4);
		queueUsing2Stacks.add(5);
		System.out.println("Remove " + queueUsing2Stacks.remove());
		queueUsing2Stacks.add(6);
		System.out.println("Remove " + queueUsing2Stacks.remove());
		queueUsing2Stacks.add(7);
		while (!queueUsing2Stacks.isEmpty()) {
			System.out.println(queueUsing2Stacks.peek());
			queueUsing2Stacks.remove();
		}
	}

}
