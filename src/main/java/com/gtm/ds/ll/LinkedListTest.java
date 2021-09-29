package com.gtm.ds.ll;

import java.util.HashMap;

public class LinkedListTest {

    ListNode head;

    public ListNode nthNodeFromEnd(int nthNode) {
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        ListNode temp = head;
        int pos = 1;
        while (temp != null) {
            hashMap.put(pos, temp);
            temp = temp.getNext();
            pos++;
        }
        int size = hashMap.size();
        if (nthNode <= size) {
            int fPos = size - nthNode + 1;
            return hashMap.get(fPos);
        }
        return null;
    }

    public void insert(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListTest test = new LinkedListTest();
        test.insert(5);
        test.insert(4);
        test.insert(3);
        test.insert(2);
        test.insert(1);
        test.print();
        System.out.println("Nth node from end :" + test.nthNodeFromEnd(5).data);
    }

}
