package com.gtm.ds.ll;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class SortedDoublyLinkedList {
    Node head, tail;

    SortedDoublyLinkedList() {
        head = tail = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void decreaseAndInsert(int K, int C) {
        Node current = head;
        while (current != null && current.data != K) {
            current = current.next;
        }

        if (current != null) {
            current.data -= C;
            Node newNode = new Node(current.data);
            if (current.prev == null) {
                head = newNode;
            } else {
                current.prev.next = newNode;
                newNode.prev = current.prev;
            }
            newNode.next = current;
            current.prev = newNode;
        }
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // function to insert a new node in sorted way in
    // a sorted doubly linked list
    public Node sortedInsert(Node head, Node newNode) {
        Node current;

        // if list is empty
        if (head == null)
            head = newNode;

            // if the node is to be inserted at the beginning
            // of the doubly linked list
        else if (head.data >= newNode.data) {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        } else {
            current = head;

            // locate the node after which the new node
            // is to be inserted
            while (current.next != null &&
                    current.next.data < newNode.data)
                current = current.next;

            /* Make the appropriate links */
            newNode.next = current.next;

            // if the new node is not inserted
            // at the end of the list
            if (current.next != null)
                newNode.next.prev = newNode;

            current.next = newNode;
            newNode.prev = current;

        }
        return head;
    }

    public static void main(String[] args) {
        SortedDoublyLinkedList list = new SortedDoublyLinkedList();
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.insert(8);
        list.insert(10);
        System.out.println("Original list:");
        list.printList();

        list.decreaseAndInsert(6, 3);
        System.out.println("List after decreasing 6 by 3 and inserting:");
        list.printList();

        list.decreaseAndInsert(8, 5);
        System.out.println("List after decreasing 8 by 5 and inserting:");
        list.printList();
    }
}
