package com.gtm.node;

public class SortedLinkedList {

	Node head;

	public void sortedInsertion(Node node){
		Node current = head;
		if (current == null) {
			node.next = node;
			head = node;
		}else if (current.data >= node.data) {
			while (current.next != head) 
				current = current.next;

			current.next = node;
			node.next = head;
			head = node;

		}else{
			while (current.next != head && current.next.data < node.data) 
				current =current.next;

			node.next = current.next;
			current.next = node;
		}
	}

	void printCCList(){
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != head);
	}

	private static class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {

		SortedLinkedList ssl = new SortedLinkedList();

		ssl.sortedInsertion(new Node(2));
		ssl.sortedInsertion(new Node(3));
		ssl.sortedInsertion(new Node(1));
		ssl.sortedInsertion(new Node(4));
		ssl.printCCList();


	}

}
