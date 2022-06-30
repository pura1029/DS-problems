package com.gtm.ds.ll;

public class LLTest {

	Node head;

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
	}

	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data);
			if (curr.next != null) {
				System.out.print("->");
			}
			curr = curr.next;
		}

		System.out.println();
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("List empty");
			return;
		}

		head = head.next;
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("List empty");
			return;
		}

		if (head.next == null) {
			head = null;
			return;
		}

		Node prev = head;
		Node curr = head.next;

		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}

		prev.next = null;
	}

	public void reverse() {
		if (head == null || head.next == null) {
			return;
		}
		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head.next = null;
		head = prev;
	}

	public Node reverseStack(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newHead = reverseStack(head.next);
		head.next.next = head;
		head.next = null;

		return newHead;
	}

	public static void main(String[] args) {
		LLTest test = new LLTest();
		test.addFirst(2);
		test.addFirst(1);
		test.addLast(3);
		test.print();

		// test.deleteFirst();
		// test.print();
		// test.deleteLast();
		// test.print();
		test.head = test.reverseStack(test.head);
		test.print();
	}

}
