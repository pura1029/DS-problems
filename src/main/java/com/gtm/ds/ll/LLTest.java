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

	public static void main(String[] args) {
		LLTest test = new LLTest();
		test.addFirst(2);
		test.addFirst(1);
		test.print();
	}

}
