package com.gtm.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author kumarga implementation to find the sum of leaf nodes at minimum level
 *
 */
public class SumOfLeafNodes {

	Node root;

	public SumOfLeafNodes() {
		root = null;
	}

	public void addNode(int data) {
		this.root = addNodeRec(this.root, data);
	}

	private Node addNodeRec(Node node, int data) {
		if (node == null)
			return new Node(data);

		if (data < node.data)
			node.left = addNodeRec(node.left, data);
		else if (data > node.data)
			node.right = addNodeRec(node.right, data);
		return node;
	}

	public void inOrder() {
		inOrderRec(this.root);
	}

	private void inOrderRec(Node node) {

		if (node == null)
			return;
		inOrderRec(node.left);
		System.out.print(node.data + " ");

		inOrderRec(node.right);
	}

	// function to find the sum of
	// leaf nodes at minimum level
	public static int sumOfLeafNodesAtMinLevel(Node root) {
		if (root == null)
			return 0;
		// if there is only one node
		if (root.left == null && root.right == null)
			return root.data;
		Queue<Node> queue = new LinkedList<>();
		int sum = 0;
		boolean flag = true;
		queue.add(root);
		while (flag) {
			int count = queue.size();
			while (count >= 1) {
				Node top = queue.peek();
				queue.poll();
				// if it is a leaf node
				if (top.left == null && top.right == null) {
					// accumulate data to 'sum'
					sum = sum + top.data;
					// set flag 'flag' to false, to signify
					// minimum level for leaf nodes
					// has been encountered
					flag = false;
				} else {
					// if top's left and right child
					// exists, then push them to 'queue'
					if (top.left != null)
						queue.add(top.left);
					if (top.right != null)
						queue.add(top.right);
				}
				count--;
			}
			/*
			 * if (!flag && !queue.isEmpty()) { flag = true; sum = 0; }
			 */
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Node root = new Node(1); root.left = new Node(2); root.right = new Node(3);
		 * root.left.left = new Node(4); root.left.right = new Node(5); root.right.left
		 * = new Node(6); root.right.right = new Node(7); root.left.right.left = new
		 * Node(8); root.right.left.right = new Node(9);
		 */
		SumOfLeafNodes bt = new SumOfLeafNodes();
		bt.addNode(5);
		bt.addNode(1);
		bt.addNode(3);
		bt.addNode(4);
		bt.addNode(2);
		bt.addNode(6);
		bt.addNode(7);
		bt.addNode(8);
		bt.addNode(9);
		System.out.println("Sum = " + sumOfLeafNodesAtMinLevel(bt.root));
		bt.inOrder();
	}

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
