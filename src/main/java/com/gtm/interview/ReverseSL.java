package com.gtm.interview;

public class ReverseSL {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void reverseNode() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    public void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "  ");

            current = current.next;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public Node findStartNodeOfTheLoop() { // 10 11 12 13 11
        Node slowPtr = head;
        Node fastPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        System.out.println("\nis loop exist :" + loopExists);
        if (loopExists) {
            System.out.println("Loop exists at :" + slowPtr.data);
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        } else {
            System.out.println("Loop does not exists");
            slowPtr = null;
        }

        return slowPtr;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseSL reverseSL = new ReverseSL();

		/*reverseSL.addNode(1);
		reverseSL.addNode(2);
		reverseSL.addNode(3);
		reverseSL.print(reverseSL.head);
		reverseSL.reverseNode();
		System.out.println("\n-------------------------");
		reverseSL.print(reverseSL.head);*/
        Node loopNode = new Node(11);
        Node head = new Node(10);
        reverseSL.addNode(head);
        reverseSL.addNode(loopNode);//11
        reverseSL.addNode(new Node(12));
        reverseSL.addNode(new Node(13));
		/*reverseSL.addNode(new Node(14));
		reverseSL.addNode(new Node(15));
		reverseSL.addNode(new Node(16));*/
        System.out.println("\n-------------------------");
        reverseSL.printList();
        reverseSL.addNode(loopNode);
        Node startNode = reverseSL.findStartNodeOfTheLoop();

        if (startNode != null)
            System.out.println("start Node of loop is " + startNode.data);

    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}
