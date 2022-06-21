package com.gtm.ds.ll;

public class ReverseLinkedList {

	public static ListNode reverseNode(ListNode listNode) {
		ListNode prev = null;
		ListNode curr = listNode;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		LinkedListTest test = new LinkedListTest();
		test.insert(5);
		test.insert(4);
		test.insert(3);
		test.insert(2);
		test.insert(1);
		ListNode listNode = ReverseLinkedList.reverseNode(test.getHead());
		test.print(listNode);
	}

}
