package com.gtm.node.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String nodeId;
	private List<Node> children = new ArrayList<Node>();
	private Node parent;
	public Node(Node parent) {
		super();
		this.parent = parent;
	}

	public Node getRoot() {
		if(parent == null){
			return this;
		}
		return parent.getRoot();
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
}
