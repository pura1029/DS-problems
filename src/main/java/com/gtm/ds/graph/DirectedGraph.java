package com.gtm.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
public class DirectedGraph {

	private final int vertex;
	private final List<List<Integer>> adj;

	public DirectedGraph(int vertex) {
		this.vertex = vertex;
		adj = new ArrayList<>(vertex);

		for (int i = 0; i < vertex; i++) {
			adj.add(new LinkedList<>());
		}
	}

	public void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	public boolean isCyclic() {

		boolean[] visited = new boolean[vertex];
		boolean[] recStack = new boolean[vertex];

		for (int i = 0; i < vertex; i++) {
			if (isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int parent, boolean[] visited, boolean[] recStack) {

		visited[parent] = true;

		recStack[parent] = true;
		List<Integer> children = adj.get(parent);

		for (Integer neighbor : children) {
			if (!visited[neighbor]) {
				if (isCyclicUtil(neighbor, visited, recStack)) {
					return true;
				}
			} else if (recStack[neighbor]) {
				System.out.println("cycle b/w " + parent + " and " + neighbor);
				return true;
			}
		}

		recStack[parent] = false;

		return false;
	}

	public static void main(String[] args) {

		DirectedGraph graph = new DirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic()) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't " + "contain cycle");
		}
	}

}
