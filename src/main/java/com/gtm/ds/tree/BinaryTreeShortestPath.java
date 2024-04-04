package com.gtm.ds.tree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeShortestPath {
    TreeNode root;

    BinaryTreeShortestPath() {
        root = null;
    }

    int findShortestPath(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root, a, b);
        int distA = findDistance(lca, a, 0);
        int distB = findDistance(lca, b, 0);
        return distA + distB;
    }

    TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;

        TreeNode leftLCA = findLCA(root.left, a, b);
        TreeNode rightLCA = findLCA(root.right, a, b);

        if (leftLCA != null && rightLCA != null) return root;
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    int findDistance(TreeNode root, int target, int depth) {
        if (root == null) return -1;
        if (root.val == target) return depth;

        int leftDist = findDistance(root.left, target, depth + 1);
        if (leftDist != -1) return leftDist;

        int rightDist = findDistance(root.right, target, depth + 1);
        return rightDist;
    }

    public static void main(String[] args) {
        BinaryTreeShortestPath tree = new BinaryTreeShortestPath();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        int a = 4, b = 7;
        System.out.println("Shortest path between " + a + " and " + b + ": " + tree.findShortestPath(tree.root, a, b)); // Output: 3
    }
}
