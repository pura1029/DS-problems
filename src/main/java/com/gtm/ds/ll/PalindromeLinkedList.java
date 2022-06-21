package com.gtm.ds.ll;

public class PalindromeLinkedList {

	public static boolean palindrome(ListNode listNode) {

		if (listNode == null) {
			return true;
		}

		ListNode midNode = middleNode(listNode);

		ListNode lastNode = ReverseLinkedList.reverseNode(midNode.next);
		ListNode curr = listNode;
		while (lastNode != null) {
			if (lastNode.data != curr.data) {
				return false;
			}
			curr = curr.next;
			lastNode = lastNode.next;
		}

		return true;

	}

	private static ListNode middleNode(ListNode listNode) {
		ListNode slow = listNode;
		ListNode fast = listNode;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		LinkedListTest test = new LinkedListTest();
		test.insert(0);
		test.insert(1);
		test.insert(2);
		test.insert(3);
		test.insert(2);
		test.insert(1);
		test.print();

		System.out.println(PalindromeLinkedList.palindrome(test.getHead()));
	}

}
