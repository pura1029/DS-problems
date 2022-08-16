package com.gtm.ds.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinarySearchTree {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + "]";
		}
	}

	public TreeNode insert(int[] nodes) {
		TreeNode root = null;
		for (int node : nodes) {
			root = insert(root, node);
		}
		return root;
	}

	public TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
		}

		if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}

		return root;
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public boolean search(TreeNode root, int val) {
		if (root == null) {
			return false;
		}
		if (root.data > val) {
			return search(root.left, val);
		} else if (root.data == val) {
			return true;
		} else if (root.data < val) {
			return search(root.right, val);
		}

		return false;
	}

	public TreeNode delete(TreeNode root, int val) {
		if (root == null) {
			return root;
		}
		if (root.data > val) {
			root.left = delete(root.left, val);
		} else if (root.data < val) {
			root.right = delete(root.right, val);
		} else { // if root.data == val

			// case 1 : if node is leaf(no child)
			if (root.left == null && root.right == null) {
				return null;
			}
			// case 2 : if node having one child
			if (root.left == null) {// if left subtree is empty then return right subtree.
				return root.right;
			} else if (root.right == null) { // if right subtree is empty then return left subtree.
				return root.left;
			}

			// case 3 : if node having two childs

			TreeNode inSuccNode = inorderSuccessor(root.right);// find left most node in right subtree.
			// replace inorderSuccessor node data with root
			root.data = inSuccNode.data;
			// delete the inorderSuccessor node from right subtree.
			root.right = delete(root.right, inSuccNode.data);
		}

		return root;
	}

	/**
	 * Find left most node(means, smaller node) in right subtree.
	 * 
	 * @param root
	 * @return
	 */
	private TreeNode inorderSuccessor(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	public void printInRange(TreeNode root, int from, int to) {
		if (root == null) {
			return;
		}
		// case 1 : if from <= root.data <= to; search in left and right subtree
		if (root.data >= from && root.data <= to) {
			printInRange(root.left, from, to);
			System.out.print(root.data + " ");
			printInRange(root.right, from, to);
		} else if (root.data >= to) {// case 2: if root.data >= to; search in left subtree
			printInRange(root.left, from, to);
		} else {
			printInRange(root.right, from, to); // case 3 : if root.data <= from; search in right subtree
		}
	}

	public void printRoot2Leaf(TreeNode root, List<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.data);
		// print path if node is leaf
		if (root.left == null && root.right == null) {
			printPath(path);
		} else { // non-leaf
			printRoot2Leaf(root.left, path);
			printRoot2Leaf(root.right, path);
		}
		// back tracking(reach to leaf node remove current rooted node)
		path.remove(path.size() - 1);
	}

	private void printPath(Collection<Integer> path) {
		Iterator<Integer> iterator = path.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
			if (iterator.hasNext()) {
				System.out.print("->");
			}
		}
		System.out.println();
	}

	public void printLeftView(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();

		printLeftViewUtil(root, map, 1);

		printPath(map.values());
	}

	private void printLeftViewUtil(TreeNode root, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}

		map.putIfAbsent(level, root.data);
		printLeftViewUtil(root.left, map, level + 1);
		printLeftViewUtil(root.right, map, level + 1);
	}

	public void printRightView(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();

		printRightViewUtil(root, map, 1);

		printPath(map.values());
	}

	private void printRightViewUtil(TreeNode root, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}

		map.put(level, root.data);
		printRightViewUtil(root.left, map, level + 1);
		printRightViewUtil(root.right, map, level + 1);
	}

	// https://www.hackerrank.com/challenges/tree-top-view/problem
	// https://www.geeksforgeeks.org/print-nodes-in-the-top-view-of-binary-tree-set-3/
	public void topView(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<Pair> queue = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			map.putIfAbsent(pair.horizontalDistance, pair.node.data);

			if (pair.node.left != null) {
				queue.add(new Pair(pair.node.left, pair.horizontalDistance - 1));
			}

			if (pair.node.right != null) {
				queue.add(new Pair(pair.node.right, pair.horizontalDistance + 1));
			}
		}

		map.values().forEach(ele -> {
			System.out.print(ele + " ");
		});
		System.out.println();
	}

	static class Pair {
		TreeNode node;
		int horizontalDistance;

		public Pair(TreeNode node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
	}

	public void bottomView(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<Pair> queue = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			map.put(pair.horizontalDistance, pair.node.data);

			if (pair.node.left != null) {
				queue.add(new Pair(pair.node.left, pair.horizontalDistance - 1));
			}

			if (pair.node.right != null) {
				queue.add(new Pair(pair.node.right, pair.horizontalDistance + 1));
			}
		}

		map.values().forEach(ele -> {
			System.out.print(ele + " ");
		});
		System.out.println();
	}

	public void printPathBw2Nodes(TreeNode root, int node1, int node2) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();

		if (!findPath4Node(root, node1, path1)) {
			System.out.println("Node1 not found " + node1);
			return;
		}
		if (!findPath4Node(root, node2, path2)) {
			System.out.println("Node2 not found " + node2);
			return;
		}
		int intersection = -1;
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {

			if (!path1.get(i).equals(path2.get(i))) {
				intersection = i - 1;
				break;
			}

		}
		System.out.print("Path b/w nodes " + node1 + " and " + node2 + ": ");
		for (i = path1.size() - 1; i > intersection; i--) {
			System.out.print(path1.get(i) + " ");
		}

		for (i = intersection; i < path2.size(); i++) {
			System.out.print(path2.get(i) + " ");
		}

		System.out.println();
	}

	private boolean findPath4Node(TreeNode root, int node, List<Integer> path) {

		if (root == null) {
			return false;
		}
		path.add(root.data);
		if (root.data == node) {
			return true;
		}
		if (findPath4Node(root.left, node, path) || findPath4Node(root.right, node, path)) {
			return true;
		}
		// If not present in subtree rooted with root, remove root from
		// path[] and return false
		path.remove(path.size() - 1);
		return false;
	}

	// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	public int findLCA1(TreeNode root, int node1, int node2) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();

		if (!findPath4Node(root, node1, path1)) {
			System.out.println("Node1 not found " + node1);
			return -1;
		}
		if (!findPath4Node(root, node2, path2)) {
			System.out.println("Node2 not found " + node2);
			return -1;
		}
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {

			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}

		}

		return path1.get(i - 1);
	}

	public int findLCA(TreeNode root, int node1, int node2) {
		return findLCAUtil(root, node1, node2).data;
	}

	public TreeNode findLCAUtil(TreeNode root, int node1, int node2) {
		if (root == null || root.data == node1 || root.data == node2) {
			return root;
		}

		TreeNode left = findLCAUtil(root.left, node1, node2);
		TreeNode right = findLCAUtil(root.right, node1, node2);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}

		int lMax = getMax(root.left);

		int rMin = getMin(root.right);

		if (lMax < root.data && rMin > root.data) {
			return (isValidBST(root.left) && isValidBST(root.right));
		}

		return false;
	}

	private int getMin(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int res = root.data;

		int lMin = getMin(root.left);
		int rMin = getMin(root.right);

		return Math.min(Math.min(lMin, res), rMin);
	}

	private int getMax(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int res = root.data;
		int lMax = getMax(root.left);
		int rMax = getMax(root.right);

		return Math.max(Math.max(lMax, res), rMax);
	}

	public boolean isValidBST2(TreeNode root) {
		return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBSTUtil(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data < min || root.data > max) {
			return false;
		}

		return (isValidBSTUtil(root.left, min, root.data - 1) && isValidBSTUtil(root.right, root.data + 1, max));
	}

	TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (!isValidBST(root.left)) {
			return false;
		}

		if (prev != null && root.data <= prev.data) {
			return false;
		}
		prev = root;

		return isValidBST(root.right);

	}

	public static void main(String[] args) {

		int[] nodes = { 5, 1, 3, 4, 2, 7 };

		BinarySearchTree searchTree = new BinarySearchTree();

		TreeNode root = searchTree.insert(nodes);
		searchTree.inOrder(root);
		System.out.println();
		// System.out.println(searchTree.search(root, 4) ? "Found" : "Not Found");

		// searchTree.delete(root, 3);
		// searchTree.inOrder(root);
		// System.out.println();
		// searchTree.printInRange(root, 1, 5);

		// searchTree.printRoot2Leaf(root, new ArrayList<>());

		// searchTree.printLeftView(root);
		// searchTree.printRightView(root);

		// searchTree.printPathBw2Nodes(root, 3, 7);

		System.out.println("LCA " + searchTree.findLCA(root, 3, 7));

		// System.out.println(searchTree.isValidBST(root));

		searchTree.topView(root);
		searchTree.bottomView(root);
	}

}
