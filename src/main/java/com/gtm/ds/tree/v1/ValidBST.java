/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.tree.v1;

/**
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * <p>
 * A Binary Search Tree (BST) is a node-based binary tree data structure that has the following properties.
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Each node (item in the tree) has a distinct key.
 *
 * @author kumargautam
 */
public class ValidBST {

    public static class Node {
        public int data;
        public Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node prev;

    static Boolean isBSTUtil(Node root) {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null) {
            if (!isBSTUtil(root.left)) {
                return false;
            }

            // Allows only distinct valued nodes
            if (prev != null && root.data <= prev.data) {
                return false;
            }

            prev = root;

            return isBSTUtil(root.right);
        }
        return true;
    }

    static Boolean isBST(Node root) {
        return isBSTUtil(root);
    }

    // Driver Code
    public static void main(String[] args) {
        /*Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);*/

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);


        // Function call
        if (isBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }
}
