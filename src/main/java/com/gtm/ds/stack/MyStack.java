package com.gtm.ds.stack;

public class MyStack<T> {
	private Node<T> head;
	private int size;

	public MyStack() {
		head = null;
		size = 0;
	}

	public T push(T data) {

		Node<T> newNode = new Node<>(data);
		newNode.next = head;
		head = newNode;
		size++;
		return data;
	}

	public T peek() {
		if (head == null) {
			throw new IllegalStateException("Stack empty");
		}

		return head.data;
	}

	public T pop() {
		if (head == null) {
			throw new IllegalStateException("Stack empty");
		}

		T res = head.data;
		head = head.next;
		size--;
		return res;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public void print() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
			if (temp != null) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		stack.print();

	}

}
