package com.gtm.ds.ll;

import lombok.Data;

@Data
public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

	@Override
	public String toString() {
		return "ListNode [data=" + data + "]";
	}
}
