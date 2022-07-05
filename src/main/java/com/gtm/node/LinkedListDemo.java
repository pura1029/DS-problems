package com.gtm.node;

public class LinkedListDemo {

	private Node head;
	private static class Node {
		private int value;
		private Node next;
		Node(int value) {
			super();
			this.value = value;
		}

	}
	public void addToTheLast(int value) {
		LinkedListDemo.Node newNode = new LinkedListDemo.Node(value);
		if (head == null) {
			head = newNode;
		}else{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newNode;
		}
	}
	
	public void printList() {  
		Node temp = head;
		while(temp != null){
			System.out.format("%d", temp.value);
			temp = temp.next;
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListDemo linkedListDemo = new LinkedListDemo();
		linkedListDemo.addToTheLast(1);
		linkedListDemo.addToTheLast(2);
		linkedListDemo.addToTheLast(3);
		linkedListDemo.addToTheLast(4);
		linkedListDemo.printList();
	}

}
