package com.gtm.node;

public class ReverseLinkedList {

	private static Node head;
	public static void main(String[] args) {
		Node node1 = new Node(1);
		head = node1;
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		node1.next = node2;
		node2.prev = node1;

		node3.prev = node2;
		node2.next = node3;

		node4.prev = node3;
		node3.next = node4;

		node5.prev = node4;
		node4.next = node5;

		print(head);
		System.out.println("\nAfter reverse");
		reverse(head);
		System.out.println("\nAfter reverse");
		reverse(head);
		System.out.println("\nAfter reverse");
		reverse(head);
	}

	private static class Node {
		int data;
		Node next, prev;

		public Node(int data) {
			this.data = data;
		}
	}

	private static void print(Node node){
		while(node!=null){
			System.out.print(node.data+ "->");
			node = node.next;
		}
	}

	private static void reverse(Node node){ //1->2->3->4->5->
		Node prev = null;
		Node curr = node;
		while(curr != null){
			prev = curr.prev;
			curr.prev = curr.next;
			curr.next = prev;
			curr = curr.prev;
		}

		if(prev != null)
			head = prev.prev;
		print(head);
	}

}
