package com.gtm.node;

import java.util.NoSuchElementException;

public class DoublyLinkedListTest1 < E > {

	static int noOfNode = 0;
	DNode < E > head;
	DNode < E > tail;
	DNode < E > current;
	DNode < E > temp;

	public void addNode(E data) {
		DNode < E > dNode = new DNode < E > (data);
		if (head == null) {
			head = dNode;
			head.setNextNode(null);
			head.setPrevNode(null);
			tail = dNode;
		} else {
			current = tail;
			current.setNextNode(dNode);
			dNode.setPrevNode(tail);
			dNode.setNextNode(null);
			tail = dNode;

		}
	}

	public void addFirstNode(E data) {
		DNode < E > dNode = new DNode < E > (data);
		if (head == null) {
			head = dNode;
			head.setNextNode(null);
			head.setPrevNode(null);
			tail = dNode;
		} else {
			current = head;
			current.setPrevNode(dNode);
			dNode.setNextNode(head);
			dNode.setPrevNode(null);
			head = dNode;

		}
	}

	public void printNode() {
		current = head;
		System.out.println("printNode in forward");
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNextNode();
		}
	}

	public void printNodeBack() {
		current = tail;
		System.out.println("printNode in backward");
		while (current != null) {
			System.out.println(current.getData());
			current = current.getPrevNode();
		}
	}

	public E removeFirst() {
		if (noOfNode == 0) throw new NoSuchElementException();
		current = head;
		head = head.getNextNode();
		head.setPrevNode(null);
		noOfNode--;
		System.out.println("deleted: " + current.getData());
		return current.getData();
	}

	public static void main(String[] args) {
		DoublyLinkedListTest1 < Integer > listTest1 = new DoublyLinkedListTest1 < Integer > ();
		listTest1.addNode(1);
		listTest1.addNode(2);
		listTest1.addNode(3);
		listTest1.addFirstNode(0);
		listTest1.addFirstNode(-1);
		listTest1.printNode();
		listTest1.removeFirst();
		listTest1.printNode();
		listTest1.printNodeBack();
	}


}

class DNode < E > {
	private E data;
	private DNode < E > nextNode;
	private DNode < E > prevNode;
	public DNode(E data) {
		this.data = data;
		DoublyLinkedListTest1.noOfNode++;
	}
	public DNode < E > getNextNode() {
		return nextNode;
	}
	public void setNextNode(DNode < E > nextNode) {
		this.nextNode = nextNode;
	}
	public DNode < E > getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(DNode < E > prevNode) {
		this.prevNode = prevNode;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
}