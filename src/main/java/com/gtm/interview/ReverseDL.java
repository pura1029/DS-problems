package com.gtm.interview;

public class ReverseDL {

	Node head = null;
	Node tail = null;
	Node current = null;
	Node temp = null;

	public  void addNode(int data){
		Node newNode = new Node(data);
		if (head == null ) {
			head = newNode;
			head.next = null;
			head.prev = null;
			tail = newNode;
		}else{
			current = tail;
			current.next = newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}
	}
	public  void addNodeFirst(int data){
		Node newNode = new Node(data);
		if (head == null ) {
			head = newNode;
			head.next = null;
			head.prev = null;
			tail = newNode;
		}else{
			current = head;
			current.prev = newNode;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
		}
	}
	
	public  void reverseNode(){
		current = head;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if (temp != null) {
			head = temp.prev;
			tail = temp;
		}
	}

	public void print(Node head){
		Node current = head;
		while(current!=null){
			System.out.print(current.data + "  ");

			current = current.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseDL reverseDL = new ReverseDL();
		reverseDL.addNode(1);
		reverseDL.addNode(2);
		reverseDL.addNode(3);
		reverseDL.addNode(4);
		reverseDL.addNodeFirst(0);
		reverseDL.print(reverseDL.head);
		reverseDL.reverseNode();
		System.out.println("\n-------------------------");
		reverseDL.print(reverseDL.head);
	}

}
class Node{
	int data;
	Node prev;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}
