package com.gtm.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.gtm.ds.tree.BinaryTreesYT.TreeNode;
import lombok.ToString;

//https://www.youtube.com/watch?v=-DzowlcaUmE&t=928s&ab_channel=ApnaCollege
public class BinaryTreesYT {

	@ToString
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.buildTree(nodes);

		// System.out.println(root.data);
		// tree.preOrder(root);// o/p : 1,2,4,5,3,6

		// tree.inOrder(root); // o/p : 2,4,5,1,3,6

		// tree.postOrder(root); // o/p : 4,5,2,6,3,1
		tree.levelOrder(root); // o/p: 1,2,3,4,5,6
		// System.out.println(tree.nThLevelSum(root, 3));
		// System.out.println(tree.maxLevelSum(root));

		// System.out.println(tree.countOfNodes(root));

		// System.out.println(tree.sumOfNodes(root));

		// System.out.println(tree.height(root));
		// System.out.println(tree.diameter1(root));

		// System.out.println(tree.diameter(root).diam);

		tree.diameter2(root);
		System.out.println(tree.ans);

		TreeNode subTree = new TreeNode(2);
		subTree.left = new TreeNode(4);
		subTree.right = new TreeNode(5);

		System.out.println(tree.isSubtree(root, subTree));
	}
}

class BinaryTree {

	static int idx = -1;

	public TreeNode buildTree(int[] nodes) {
		idx++;
		if (nodes[idx] == -1) {
			return null;
		}

		TreeNode newNode = new TreeNode(nodes[idx]);
		newNode.left = buildTree(nodes);
		newNode.right = buildTree(nodes);

		return newNode;
	}

	public void preOrder(TreeNode root) {// root --> left sub tree --> right sub tree
		if (root == null) {
			return;
		}

		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(TreeNode root) {// left sub tree --> root --> right sub tree
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public void postOrder(TreeNode root) {// left sub tree --> right sub tree --> root
		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			TreeNode currNode = queue.remove();

			if (currNode == null) {
				System.out.println();
				if (queue.isEmpty()) {
					break;
				} else {
					queue.add(null);
				}
			} else {
				System.out.print(currNode.data + " ");

				if (currNode.left != null) {
					queue.add(currNode.left);
				}

				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
		}
	}

	public int nThLevelSum(TreeNode root, int level) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int currLevel = 0;
		int sum = 0;
		boolean flag = false;

		while (!queue.isEmpty()) {
			currLevel++;
			int size = queue.size();
			while (size-- > 0) {
				TreeNode currNode = queue.remove();
				if (currLevel == level) {
					flag = true;
					sum += currNode.data;

				} else {
					if (currNode.left != null) {
						queue.add(currNode.left);
					}

					if (currNode.right != null) {
						queue.add(currNode.right);
					}
				}
			}
			if (flag) {
				break;
			}
		}

		return sum;
	}

//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
	public int maxLevelSum(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int currLevel = 0;
		int maxSum = Integer.MIN_VALUE;
		int level = currLevel;

		while (!queue.isEmpty()) {
			currLevel++;
			int size = queue.size();
			int sum = 0;
			while (size-- > 0) {
				TreeNode currNode = queue.remove();
				sum += currNode.data;

				if (currNode.left != null) {
					queue.add(currNode.left);
				}

				if (currNode.right != null) {
					queue.add(currNode.right);
				}

			}
			if (sum > maxSum) {
				maxSum = sum;
				level = currLevel;
			}
		}

		return level;
	}

	public int countOfNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftCount = countOfNodes(root.left);
		int rightCount = countOfNodes(root.right);

		return (leftCount + rightCount + 1);// leftCount + rightCount + self count
	}

	public int sumOfNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);

		return (leftSum + rightSum + root.data);// leftSum + rightSum + self data
	}

	public int height(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(leftHeight, rightHeight) + 1;// max(leftHight, rightHight) + self height
	}

//https://leetcode.com/problems/diameter-of-binary-tree/
	public int diameter1(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int diam1 = diameter1(root.left);
		int diam2 = diameter1(root.right);
		int diam3 = this.height(root.left) + this.height(root.right) + 1;

		return Math.max(diam3, Math.max(diam1, diam2));

	}

	int ans = 0;

	public int diameter2(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int diam1 = diameter2(root.left);
		int diam2 = diameter2(root.right);
		ans = Math.max(ans, (1 + diam1 + diam2));

		return (Math.max(diam1, diam2) + 1);

	}

	static class TreeInfo {
		int height;
		int diam;

		public TreeInfo(int height, int diam) {
			this.height = height;
			this.diam = diam;
		}
	}

//https://leetcode.com/problems/diameter-of-binary-tree/
	public TreeInfo diameter(TreeNode root) {

		if (root == null) {
			return new TreeInfo(0, 0);
		}

		TreeInfo leftTreeInfo = diameter(root.left);
		TreeInfo rightTreeInfo = diameter(root.right);
		int myHeight = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;

		int diam1 = leftTreeInfo.diam;
		int diam2 = rightTreeInfo.diam;
		int diam3 = leftTreeInfo.height + rightTreeInfo.height + 1;

		int myDiam = Math.max(diam3, Math.max(diam1, diam2));

		return new TreeInfo(myHeight, myDiam);
	}

//https://leetcode.com/problems/subtree-of-another-tree/
	public boolean isSubtree(TreeNode root, TreeNode subTree) {
		if (subTree == null) {
			return true;
		}

		if (root == null) {
			return false;
		}

		if (root.data == subTree.data && isIdentical(root, subTree)) {
			return true;
		}
		// if root node data not matched
		return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
	}

	private boolean isIdentical(TreeNode root, TreeNode subTree) {
		// both tree reach to leaf node
		if (root == null && subTree == null) {
			return true;
		}
		// one of tree reach to leaf node
		if (root == null || subTree == null) {
			return false;
		}
		if (root.data == subTree.data) {
			return isIdentical(root.left, subTree.left) && isIdentical(root.right, subTree.right);
		}

		return false;
	}
}
