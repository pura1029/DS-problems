package com.gtm.node;

import java.util.Stack;

public class FindLoopInLinkedList {
	private Node head;
	private static class Node{

		private int data;
		private Node next;
		Node(int data) {
			this.data = data;
		}
	}

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		}else{
			Node temp = head;
			while(temp != null && temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	public void printList() {
		Node temp = head;
		while(temp != null){
			System.out.format("%d ", temp.data);  
			temp = temp.next;
		}
		System.out.println();
	}

	public void printList(Node head) {  
		Node temp = head;  
		while (temp != null) {  
			System.out.format("%d ", temp.data);  
			temp = temp.next;  
		}  
		System.out.println();  
	} 

	public Node  findStartNodeOfTheLoop() {  
		Node fastPtr = head;  
		Node slowPtr = head;  
		boolean loopExists=false;
		while(fastPtr != null && fastPtr.next != null){
			fastPtr = fastPtr.next.next;  
			slowPtr = slowPtr.next;  
			if (slowPtr == fastPtr)  
			{  
				loopExists=true;  
				break;  
			}
		}
		if (loopExists) {
			System.out.println("Loop exists at :"+slowPtr.data);
			slowPtr=head;  

			while(slowPtr!=fastPtr)  
			{  
				slowPtr=slowPtr.next;  
				fastPtr=fastPtr.next;  
			}  
			return slowPtr;
		} else {
			System.out.println("Loop does not exists"); 
			return null;
		}
	}

	public  Node reverseLinkedList(Node currentNode)  
	{ 
		Node previousNode=null;  
		Node nextNode;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next=previousNode;  
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;  
	}

	public  Node reverseLinkedListUS(Node newNode)  
	{ 
		Node previousNode=null;
		Node currentNode = newNode;
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

	public Node nthFromLastNode(Node head,int n)  
	{  
		Node firstPtr=head;  
		Node secondPtr=head;  

		for (int i = 0; i < n; i++) {  
			firstPtr=firstPtr.next;  

		}  

		while(firstPtr!=null)  
		{  
			firstPtr=firstPtr.next;  
			secondPtr=secondPtr.next;  
		}  

		return secondPtr;  
	}  


	public static void main(String[] args) {
		FindLoopInLinkedList list = new FindLoopInLinkedList();  
		// Creating a linked list  
		Node loopNode=new Node(7);  
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(loopNode); 
		list.addToTheLast(new Node(6));  
		list.addToTheLast(new Node(1));  
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(4));

		list.printList();  
		//list.addToTheLast(loopNode);    

		Node startNode=list.findStartNodeOfTheLoop();  
		if(startNode!=null)  
			System.out.println("start Node of loop is "+ startNode.data);  

		// Finding 3rd node from end  
		Node nthNodeFromLast= list.nthFromLastNode(head,3);  
		System.out.println("3th node from end is : "+ nthNodeFromLast.data); 

		//Node reverseHead= list.reverseLinkedList(head); 
		Node reverseHead= list.reverseLinkedListUS(head); 
		System.out.println("After reversing");  
		list.printList(reverseHead);


	}

}
