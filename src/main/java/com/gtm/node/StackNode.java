package com.gtm.node;

public class StackNode {

	SNode root;
	private int size;

	public StackNode(){
		root = null;
		size = 0;
	}

	public void push(int data){
		SNode newNode = new SNode(data);
		if (root == null) {
			root = newNode;
		}else{
			newNode.next = root;
			root = newNode;
		}
		size++;
	}

	public int pop(){
		int d = -1;
		SNode temp = root;
		if (temp != null) {
			root = root.next;
			d = temp.data;
		}
		size--;
		return d;
	}

	public void printStack(){
		SNode temp = root;
		while (temp != null) {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public int size(){
		return size;
	}
	
	public void reverseStack(){
		SNode curr ,next;
		SNode prev = null;
		curr = root;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.root = prev;
		
	}

	public static void main(String[] args) {
		StackNode sn = new StackNode();
		sn.push(1);
		sn.push(2);
		sn.push(3);
		System.out.println("Stack size :"+sn.size());
		sn.printStack();
		System.out.println("after reverse");
		sn.reverseStack();
		sn.printStack();
		sn.pop();
		System.out.println("Stack size :"+sn.size());
		sn.printStack();

	}

	static class SNode{
		int data;
		SNode next;

		public SNode(int data){
			this.data = data;
			this.next = null;
		}
	}

}
