package com.gtm.node;

import java.util.Stack;

class Node{
	public int data;
	public Node next;
	public void displayNodeData() {  
		System.out.println("{ " + data + " } ");  
	} 
	public Node(int data){
		this.data = data;
	}
	public Node(){};
}
public class SinglyLinkedList {

	private Node head;

	public boolean isEmpty(){
		return (head == null);
	}
	public void insertFirst(int data) {  
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = head;
		newNode.displayNodeData();
		head = newNode;

	}

	public int lengthOfLinkedList() {
		int count = 0;
		Node temp = head;
		while(temp != null){
			temp = temp.next;
			count ++;
		}

		return count;
	}

	public Node deleteFirst() {  
		Node temp = head;  
		head = head.next;  
		return temp;  
	}  

	// For printing Linked List  
	public void printLinkedList() {  
		System.out.println("Printing LinkedList (head --> last) ");  
		Node current = head;  
		while (current != null) {  
			current.displayNodeData();  
			current = current.next;  
		}  
		System.out.println();  
	}  

	public void deleteAfter(Node after) {  
		Node temp = head;  
		while (temp.next != null && temp.data != after.data) {  
			temp = temp.next;  
		}  
		if (temp.next != null)  
			temp.next = temp.next.next;  
	}  

	// used to insert a node at the start of linked list  
	public void insertLast(int data) {  
		Node current = head;  
		while (current.next != null) {  
			current = current.next; // we'll loop until current.next is null  
		}  
		Node newNode = new Node();  
		newNode.data = data;  
		current.next = newNode;  
	} 

	public Node deleteEven() { // { 2 } { 3 } { 4 } { 1 } { 5 } { 6 } 
		Node prev=null, curr = head;

		while(curr != null) {
			if(curr.data % 2 == 0) {
				if(prev == null) {
					Node node = curr.next;
					curr = curr.next;
					head = node;
				}
				else {
					Node node = curr.next;
					prev.next =node;
					curr = curr.next;
				}
			}
			else{
				prev = curr;
				curr = curr.next;
			}
		}
		return curr;
	}

	public  Node reverseLinkedList()  
	{ 
		Node previousNode=null;  
		Node nextNode;
		Node currentNode=head;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next=previousNode;  
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = previousNode;
		return previousNode;  
	}

	public  Node reverseLinkedListUS()  
	{ 
		Node previousNode=null;
		Node currentNode = head;
		Stack<Node> stack = new Stack<>();
		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.next;
		}
		head = currentNode;
		while (!stack.isEmpty()) {
			previousNode = stack.pop();
			Node newNod = new Node(previousNode.data);
			if (head == null) {
				head = newNod;
				head.next = null;
			}else{
				Node temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = newNod;
			}

		}
		return head;  
	}
}  

