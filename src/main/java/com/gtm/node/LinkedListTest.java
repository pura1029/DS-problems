package com.gtm.node;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertFirst(4);
		System.out.println("SinglyLinkedList length : "+linkedList.lengthOfLinkedList());
		linkedList.insertFirst(2);
		//linkedList.deleteFirst();
		linkedList.printLinkedList();
		linkedList.insertLast(3);
		linkedList.insertLast(1);
		linkedList.insertLast(5);
		linkedList.insertLast(6);
		linkedList.printLinkedList();
		linkedList.deleteEven();
		System.out.println("after delete even data node ");
		linkedList.printLinkedList();
		
		System.out.println("after reverse..");
		linkedList.reverseLinkedList();
		linkedList.printLinkedList();
	}

}
