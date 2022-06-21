package com.gtm.ds.ll;

public class CycleDetectionLinkedList {

	public static void removeCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		boolean cycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				cycle = true;
				break;
			}
		}

		if (cycle) {
			slow = head;
			ListNode prev = fast;
			while (slow != fast) {
				prev = fast;
				slow = slow.next;
				fast = fast.next;
			}
			prev.next = null;
		}
	}
	
	public static void removeCycle1(ListNode head) {
        
        ListNode point = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow){
                point = fast;
                break;
            }
        }        
         
        if(point != null){            
            slow = head;
            while(slow != fast){
                fast = fast.next;
                slow =slow.next;                
            }
             
            while(fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }

	public static ListNode detectionCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return null;
	}

	public static ListNode findNode(ListNode head) {
		ListNode meet = detectionCycle(head);
		ListNode start = head;

		while (start != meet) {
			start = start.next;
			meet = meet.next;
		}
		return start;
	}

	public static void main(String[] args) {
		LinkedListTest test = new LinkedListTest();
		ListNode head = null;
        
        ListNode node = new ListNode(5);
        head = node;        
        node.next = new ListNode(4);
        node = node.next;   
         
        ListNode node10 = new ListNode(10);
        node.next = node10;
        node = node.next;
         
        node.next = new ListNode(15);
        node = node.next;       
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(7);
        node = node.next;
        node.next = node10;
        
		ListNode meet = detectionCycle(head);
		System.out.println("Meet at :" + meet);
		System.out.println("Cycle start at :" + findNode(head));

		removeCycle(head);
		test.print(head);
	}

}
