package com.gtm.ds.stack;

public class MyStack {
	Node head;
	int size;

	public MyStack() {
		head = null;
		size = 0;
	}

	public int push(int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
		return data;
	}

	public int peek() {
		if (head == null) {
			throw new IllegalStateException("Stack empty");
		}

		return head.data;
	}

	public int pop() {
		if (head == null) {
			throw new IllegalStateException("Stack empty");
		}

		int res = head.data;
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
		Node temp=head;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
			if(temp != null) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		stack.print();
		
		

	}

}
