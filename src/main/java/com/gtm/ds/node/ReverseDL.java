package com.gtm.ds.node;

public class ReverseDL {
	static Node head = null;

	public static void pushHead(Node newHead, Node newNode ){ // Original list: 5->4->3->2->1->0 
		newNode.prev = null;
		newNode.next = newHead;
		if(newHead != null){
			newHead.prev = newNode;
		}
		head = newNode;
	}

	public static void reverseDL(){
		if(head == null || head.next == null)
			return;
		Node prev = null;
		Node curr = head, next;
		while (curr != null) {
			next = curr.next;
			pushHead(prev, curr);
			prev = curr;
			curr = next;
		}
		//head = prev;
	}
	
	public static void reverseDL1(){
		head = reverseDLRec(head);
	}
	
	public static Node reverseDLRec(Node node){
		if(node == null)
			return node;
		Node temp = node.next;
		node.next = node.prev;
		node.prev = temp;
		
		if(node.prev == null)
			return node;
		
		return reverseDLRec(node.prev);
	}

	public static void printList(Node head){
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		pushHead(head, new Node(0));
		pushHead(head, new Node(1));
		pushHead(head, new Node(2));
		pushHead(head, new Node(3));
		pushHead(head, new Node(4));
		pushHead(head, new Node(5));
		System.out.print("Original list: ");
		printList(head);
		reverseDL();
		System.out.print("\nReversed list: ");
		printList(head);
		
		reverseDL1();
		System.out.print("\nReversed list2: ");
		printList(head);
	}
	private static class Node {
		int data;
		Node prev,next;
		public Node(int data) {
			this.data = data;
			this.next = this.prev = null;
		}
	}

}
