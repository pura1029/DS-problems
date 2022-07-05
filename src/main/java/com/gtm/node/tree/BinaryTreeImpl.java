package com.gtm.node.tree;

import java.util.Stack;

class BTNode {
	BTNode left,right;
	int data;

	public BTNode(int data){
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeImpl {

	BTNode root;
	public BinaryTreeImpl(){
		root = null;
	}
	public void addNode(int data){
		this.root = addNodeRec(this.root, data);
	}
	private BTNode addNodeRec(BTNode root,int data){
		if (root == null) {
			root = new BTNode(data);
			return root;
		}

		if (data < root.data ) 
			root.left = addNodeRec(root.left, data);
		else if(data > root.data )
			root.right = addNodeRec(root.right, data);
		return root;

	}

	public void inOrder(){
		inOrderRec(root);
	}

	public void preOrder(){
		preOrderRec(root);
	}

	public void postOrder(){
		postOrderRec(root);
	}

	private void inOrderRec(BTNode root){
		if(root == null)
			return;
		inOrderRec(root.left);
		System.out.print(root.data + " ");
		inOrderRec(root.right);
	}

	public void inOrderWithStack() {
		if (root == null) 
			return;
		Stack<BTNode> stack = new Stack<>();
		BTNode current = root;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

		while (!stack.isEmpty()) {

			current = stack.pop();
			System.out.print(current.data + " ");
			if (current.right != null) {
				current = current.right;
				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			}
		}
	}

	public void inOrderIter() {

		if(root == null)
			return;

		Stack<BTNode> s = new Stack<>();
		BTNode currentNode = root;

		while(!s.empty() || currentNode != null){

			if(currentNode != null)
			{
				s.push(currentNode);
				currentNode = currentNode.left;
			}
			else
			{
				BTNode n = s.pop();
				System.out.printf("%d ",n.data);
				currentNode = n.right;
			}
		}
	}

	private void preOrderRec(BTNode root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		preOrderRec(root.left);
		preOrderRec(root.right);
	}


	public void preOrderWithStack() {
		if (root == null) 
			return;
		Stack<BTNode> stack = new Stack<>();
		BTNode current = root;
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.peek();
			System.out.print(current.data + " ");
			stack.pop();
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}

	}

	public void postOrderWithStack() {
		if (root == null) 
			return;
		Stack<BTNode> stack = new Stack<>();
		BTNode current = root, prev = root;

		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.peek();

			if (current == prev || current == prev.left || current == prev.right) {
				if(current.left!=null){
					stack.push(current.left);
				}
				else if(current.right!=null){
					stack.push(current.right);
				}
				if (current.left == null && current.right == null) {
					System.out.print(current.data + " ");
					stack.pop();	
				}
			}else if(prev==current.left){ // we are traversing up the tree from the left
				if (current.right != null) {
					stack.push(current.right);
				}else if(current.right == null){
					System.out.print(current.data + " ");
					stack.pop();
				}
			}else if(prev==current.right){ // we are traversing up the tree from the right
				System.out.print(current.data + " ");
				stack.pop();
			}
			prev = current;
		}

	}

	private void postOrderRec(BTNode root){
		if(root == null)
			return;
		postOrderRec(root.left);
		postOrderRec(root.right);
		System.out.print(root.data + " ");
	}

	public BTNode searchNode(int data){
		return searchNodeRec(root, data);
	}

	public BTNode searchNodeRec(BTNode root,int data){
		if (root == null || root.data == data) {
			return root;
		}else if (root.data > data) {
			return searchNodeRec(root.left, data);
		} else {
			return searchNodeRec(root.right, data);
		}
	}

	public void deleteKey(int key)
	{
		root = deleteRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	private BTNode deleteRec(BTNode root, int key)
	{
		/* Base Case: If the tree is empty */
		if (root == null)  return root;                              /* 4
																	   / \
																      3	  5
																     / \ / \
																    2  n n  6
																   / \     / \
																  1  n    n   9
																 /\          / \
																n  n        8   10*/

		/* Otherwise, recur down the tree */
		if (key < root.data)
			root.left = deleteRec(root.left, key);
		else if (key > root.data)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else
		{
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	private int minValue(BTNode root)
	{
		int minv = root.data;
		while (root.left != null)
		{
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	public static void main(String[] args) {
		BinaryTreeImpl bt = new BinaryTreeImpl();
		/*bt.addNode(7);
		bt.addNode(10);
		bt.addNode(4);
		bt.addNode(6);
		bt.addNode(3);
		bt.addNode(11);
		bt.addNode(9);
		bt.addNode(8);*/
		/*4
		   / \
	      3	  5
	     / \ / \
	    2  n n  6
	   / \     / \
	  1  n    n   9
	 /\          / \
	n  n        8   10*/

		bt.addNode(4);   
		bt.addNode(5);
		bt.addNode(6);
		bt.addNode(3);
		bt.addNode(2);
		bt.addNode(1);
		bt.addNode(9);
		bt.addNode(8);
		bt.addNode(10);

		System.out.println("in-order : ");
		bt.inOrder();
		System.out.println("\nin-order with stack : ");
		bt.inOrderWithStack();
		System.out.println("\nin-order with stack-2 : ");
		bt.inOrderIter();
		System.out.println("\npre-order : ");
		bt.preOrder();
		System.out.println("\npre-order with stack : ");
		bt.preOrderWithStack();
		System.out.println("\npost-order : ");
		bt.postOrder();
		System.out.println("\npost-order with stack : ");
		bt.postOrderWithStack();
		BTNode searchN = bt.searchNode(8);
		System.out.println("\nsearch :"+searchN.data);
		System.out.println("\nDelete 10");
		bt.deleteKey(9);
		System.out.println("Inorder traversal of the modified tree");
		bt.inOrder();

	}

}
