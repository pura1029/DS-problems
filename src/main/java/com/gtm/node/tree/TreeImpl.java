package com.gtm.node.tree;

public class TreeImpl {
	static Node temp;

	private static Node addChild(Node parent, String id) {
		Node node = new Node(parent);
		node.setNodeId(id);
		parent.getChildren().add(node);
		return node;
	}
	
	private static void printTree(Node node, String appender) {
		System.out.println(appender + node.getNodeId());
		for (Node eachNode : node.getChildren()) {
			printTree(eachNode, appender + appender);
		}
	}
	
	public static Node getRoot(Node child) {
		if(child == null){
			return temp;
		}else{
			temp = child;
		}
		return getRoot(child.getParent());
	}

	public static void main(String[] args) {
		Node treeRootNode = new Node(null);
		treeRootNode.setNodeId("root");
		Node childNode1 = addChild(treeRootNode, "child-1");
		Node childNode11 = addChild(childNode1, "child-11");
		addChild(childNode1, "child-12");
		
		Node childNode2 = addChild(treeRootNode, "child-2");
		addChild(childNode2, "child-21");
		
		printTree(treeRootNode, " ");
		
		System.out.println("root of child-11 : "+childNode11.getRoot().getNodeId());
		System.out.println("root op1 of child-11 : "+getRoot(childNode11).getNodeId());
	}

}
