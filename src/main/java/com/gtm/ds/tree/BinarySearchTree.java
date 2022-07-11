package com.gtm.ds.tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

		searchTree.printLeftView(root);
		searchTree.printRightView(root);
	}

}
