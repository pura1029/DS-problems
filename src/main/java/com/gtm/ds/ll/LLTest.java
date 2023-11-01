package com.gtm.ds.ll;

public class LLTest {

    Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + "]";
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        addLast(newNode);
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print("->");
            }
            curr = curr.next;
        }

        System.out.println();
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = null;
        head = prev;
    }

    public Node reverseStack(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseStack(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if (head.next == null) {
            return null;
        }

        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (size < n) {
            return head;
        }

        if (size == n) {
            return head.next;
        }

        int prevNthNode = size - n;

        Node prev = head;
        int i = 1;
        while (i < prevNthNode) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public boolean isPlindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node secondHalfStart = reverse(middle.next);

        Node firstHalfStart = head;
        while (secondHalfStart != null) {
            if (secondHalfStart.data != firstHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    private Node reverse(Node middle) {
        Node prev = null;
        Node curr = middle;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private Node findMiddle(Node head1) {
        Node slow = head1;
        Node fast = head1;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasCycle(Node curr) {
        if (head == null) {
            return false;
        }
        Node slow = curr;
        Node fast = curr;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public Node findCycleStartNode(Node curr) {
        if (head == null) {
            return null;
        }
        Node slow = curr;
        Node fast = curr;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public Node removeCycle(Node curr) {
        if (head == null) {
            return null;
        }
        Node slow = curr;
        Node fast = curr;
        boolean foundCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                foundCycle = true;
                break;
            }
        }

        slow = head;
        Node prev = null;
        while (foundCycle && fast != null) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }

        if (foundCycle && fast != null) {
            prev.next = null;
        }

        return curr;
    }

    public static void main(String[] args) {
        LLTest test = new LLTest();
        test.addFirst(2);
        test.addFirst(1);
        Node node3 = new Node(3);
        test.addLast(node3);
        test.addLast(4);
        test.addLast(5);
        test.addLast(node3);
        //test.print();//1->2->3->4->5

        // test.deleteFirst();
        // test.print();
        // test.deleteLast();
        // test.print();
        // test.head = test.reverseStack(test.head);
        // test.print();

        // test.head = test.removeNthFromEnd(test.head, 2);
        // test.print();

        // System.out.println("isPlindrome :"+test.isPlindrome(test.head));

        System.out.println("hasCycle :" + test.hasCycle(test.head));

        // System.out.println("Cycle Node :" + test.findCycleStartNode(test.head));

        test.removeCycle(test.head);
        test.print();
    }

}
