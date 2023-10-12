package com.gtm.ds.ll;

import java.util.HashMap;
//https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
public class LinkedListTest {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

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

    public ListNode nthNodeFromEnd1(int nthNode) {
        ListNode mainNode = head;
        ListNode refNode = head;

        int count = 0;
        if (head != null) {
            while (count < nthNode) {
                if (refNode == null) {
                    System.out.println(nthNode + " is greater than the no of nodes in the list");
                    return null;
                }
                refNode = refNode.getNext();
                count++;
            }

            if (refNode == null && head != null) {
                return head;
            } else {
                while (refNode != null) {
                    mainNode = mainNode.next;
                    refNode = refNode.next;
                }
                return mainNode;
            }
        }
        return null;
    }

    public void insert(int data) {
        ListNode node = new ListNode(data);
        insert(node);
    }

    public void insert(ListNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void print() {
        print(this.getHead());
    }

    public void print(ListNode temp) {
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
        test.print();//1->2->3->4->5
        System.out.println("Nth node from end :" + test.nthNodeFromEnd(5).data);
        System.out.println("Nth node from end :" + test.nthNodeFromEnd1(2).data);
    }

}
