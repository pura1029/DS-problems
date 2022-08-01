package com.gtm.ds.ll;

//https://leetcode.com/problems/add-two-numbers/
public class Sum2LL {

	ListNode ansHead = null;
	ListNode ansTail = null;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}

			sum += carry;

			carry = sum / 10;
			int newVal = sum % 10;
			addNewNode(newVal);
		}

		if (carry != 0) {
			addNewNode(carry);
		}

		return ansHead;
	}

	private void addNewNode(int newVal) {
		ListNode newNode = new ListNode(newVal);
		if (ansTail == null) {
			ansHead = newNode;
			ansTail = newNode;
			return;
		}
		ansTail.next = newNode;
		ansTail = newNode;
	}

	public static void main(String[] args) {
		LinkedListTest linkedListTest1 = new LinkedListTest();
		linkedListTest1.insert(3);
		linkedListTest1.insert(4);
		linkedListTest1.insert(2);

		LinkedListTest linkedListTest2 = new LinkedListTest();
		linkedListTest2.insert(4);
		linkedListTest2.insert(6);
		linkedListTest2.insert(5);

		Sum2LL sum2ll = new Sum2LL();

		ListNode listNode = sum2ll.addTwoNumbers(linkedListTest1.getHead(), linkedListTest2.getHead());
		linkedListTest1.print(listNode);
	}

}
