package com.gtm.node;

import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<E> {

	private Node head;
	private Node tail;
	private int size;
	private Node current;
	private boolean isFirst = true;

	public DoublyLinkedListImpl() {
		size = 0;
	}
	/**
	 *  returns the size of the linked list
	 * @return
	 */
	public int size() { 
		return size; 
	}

	/**
	 * return whether the list is empty or not
	 * @return
	 */
	public boolean isEmpty() { 
		return size == 0; 
	}

	/**
	 * adds element at the starting of the linked list
	 * @param element
	 */
	public void addFirst(E data) {
		Node temp = new Node(data, head, null);
		if (head != null) {
			head.prev = temp;
		}

		head = temp;

		if (tail == null) {
			tail = temp;
		}
		size++;
		System.out.println("adding: "+data);
	}

	/**
	 * adds element at the Last of the linked list
	 * @param element
	 */
	public void addLast(E data) {
		Node temp = new Node(data, null, tail);
		if (tail != null) {
			tail.next = temp;
		}

		tail = temp;

		if (head == null) {
			head = temp;
		}
		size++;
		System.out.println("adding: "+data);
	}

	public Node addLast2(E data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			newNode.prev = null;
			newNode.next = null;
			tail = newNode;
		}else{
			Node current = head;
			while (current.next != null) 
				current = current.next;
			current.next = newNode;
			newNode.prev = current;
			tail = newNode;
		}
		size++;
		System.out.println("adding: "+data);
		return newNode;
	}

	public Node insertAfter(Node prev_node, E data) {
		if (prev_node == null)
		{
			System.out.println("the given previous node cannot be NULL");
			return null;
		}
		if(prev_node.prev == null)
			head = prev_node;
		Node temp = new Node(data);
		temp.next = prev_node.next;
		prev_node.next = temp;
		temp.prev = prev_node;
		if(temp.next != null)
			temp.next.prev = temp;
		if(temp.next == null)
			tail = temp;

		size++;
		System.out.println("adding: "+data);
		return temp;
	}
	public Node insertBefore(Node next_node, E data) {
		if (next_node == null)
		{
			System.out.println("the given next node cannot be NULL");
			return null;
		}
		if(next_node.prev == null)
			head = next_node;
		if(next_node.next == null)
			tail = next_node;
		Node temp = new Node(data);
		temp.next = next_node;
		temp.prev = next_node.prev;
		if (next_node.prev != null) 
			next_node.prev.next = temp;
		next_node.prev = temp;

		size++;
		System.out.println("adding: "+data);
		return temp;

	}

	/**
	 * this method walks forward through the linked list
	 */
	public void iterateForward(){

		System.out.println("iterating forward..");
		Node temp = head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * this method walks forward through the linked list
	 */
	public void iterateBackward(){

		System.out.println("iterating backward..");
		Node temp = tail;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}

	public void reverseDL(){
		Node temp = null;
		current = head;
		head = tail;
		tail = current;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		if (temp != null) {
			head = temp.prev;
		}
	}


	/**
	 * this method checkes weather node having next element or not
	 * @return
	 */
	public boolean hasNext(){
		if (isFirst) {
			current = head;
			return true;
		}else{
			if (current != null) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * this method returns next node element
	 * @return
	 */
	public Object next(){
		Node temp = current;
		current = current.next;
		isFirst = false;
		return temp.data;
	}

	/**
	 * this method removes the first element from linked list
	 * @return
	 */
	public E removeFirst() {
		if(size == 0) throw new NoSuchElementException();
		Node temp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: "+temp.data);
		return temp.data;
	}

	public E removeNode(Node delNode) {
		if(size == 0) throw new NoSuchElementException();
		if (head == null || delNode == null) {
			return null;
		}
		if (head == delNode) 
			head = delNode.next;
		if (delNode.next != null) 
			delNode.next.prev = delNode.prev;
		if (delNode.prev != null) 
			delNode.prev.next = delNode.next;

		size--;
		System.out.println("deleted: "+delNode.data);
		return delNode.data;
	}

	/**
	 * this method removes last element from linked list
	 * @return
	 */
	public E removeLast() {
		if(size == 0) throw new NoSuchElementException();
		Node temp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println("deleted: "+temp.data);
		return temp.data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<Integer>();
		dll.addFirst(10);
		dll.addFirst(12);
		dll.addFirst(13);
		dll.addLast(14);
		dll.iterateForward();
		dll.insertAfter(dll.head, 11);
		dll.iterateForward();
		DoublyLinkedListImpl.Node node15 = dll.addLast2(15);
		dll.insertBefore(node15, 14_4);
		dll.insertAfter(dll.tail, 17);
		dll.insertAfter(node15, 16);
		dll.iterateForward();
		dll.removeNode(node15);
		dll.iterateForward();
		dll.iterateBackward();
		System.out.println("after reverse..");
		dll.reverseDL();
		dll.iterateForward();
		dll.iterateBackward();

		dll.removeFirst();
		dll.removeLast();
		System.out.println("iterating while..");
		while(dll.hasNext()){
			System.out.println(dll.next());
		}

	}

	/**
	 * this class keeps track of each element information
	 * @author kumarga
	 *
	 */
	private class Node{
		private E data;
		private Node next;
		private Node prev;
		public Node(E data, Node next, Node prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		public Node(E data){
			this.data = data;
		}

	}

}
