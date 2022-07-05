package com.gtm.node;

public class CircularSinglyLinkedList {

	Node last;


	public static void main(String[] args) {
		CircularSinglyLinkedList cs = new CircularSinglyLinkedList();
		cs.addBegin(4);
		cs.addBegin(3);
		Node node1 = cs.addBegin(1);
		cs.addEnd(5);
		cs.addAfter(2, node1.data);
		cs.printCCSL();

	}

	public Node addBegin(int data){
		Node newNode = new Node(data);
		if (last == null) {
			last = newNode;
			newNode.next = last;
		}else{
			newNode.next = last.next;
			last.next = newNode;
		}
		return newNode;
	}

	public Node addEnd(int data){
		Node newNode = new Node(data);
		if (last == null) {
			last = newNode;
			newNode.next = last;
		}else{
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		return newNode;
	}

	public Node addAfter(int data,int item){
		if (last == null) 
			return null;

		Node newNode = null;
		Node temp = last.next;
		do {
			if (temp.data == item) {
				newNode = new Node(data);
				newNode.next = temp.next;
				temp.next = newNode;
				if(temp == last)
					last = newNode;
				return newNode;
			}
			temp = temp.next;

		} while (temp != last.next);
		return 	newNode;

	}

	public void printCCSL(){
		System.out.println("circular list data :");
		Node temp = last.next;
		do {
			System.out.print(temp.data +" ");
			temp = temp.next;
		} while (temp != last.next);
		System.out.println();
	}

	class Node{
		public int data;
		public Node next;
		public Node(int data){
			this.data = data;
		}
	}

}
