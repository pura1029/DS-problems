package com.gtm.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRootVertex {

	static class Edge {
		int source, dest;

		public Edge(int source, int dest) {
			this.source = source;
			this.dest = dest;
		}
	}

	// A class to represent a graph object
	static class Graph {
		// A list of lists to represent an adjacency list
		List<List<Integer>> adjList = null;

		// Constructor
		Graph(List<Edge> edges, int n) {
			adjList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				adjList.add(new ArrayList<>());
			}

			// add edges to the directed graph
			for (Edge edge : edges) {
				adjList.get(edge.source).add(edge.dest);
			}
		}
	}

	public static void dfs(Graph graph, int v, boolean[] visited) {
		visited[v] = true;

		for (int u : graph.adjList.get(v)) {
			if (!visited[u]) {
				dfs(graph, u, visited);
			}
		}
	}

	private static int findRootVertex(Graph graph, int n) {
		boolean[] visited = new boolean[n];

		// find the last starting vertex `v` in DFS
		int v = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, i, visited);
				v = i;
			}
		}

		// reset the visited vertices
		Arrays.fill(visited, false);

		// perform DFS on the graph from the last starting vertex `v`
		dfs(graph, v, visited);

		// return -1 if all vertices are not reachable from vertex `v`
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				return -1;
			}
		}

		return v;
	}

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 0), new Edge(4, 3),
				new Edge(4, 5), new Edge(5, 0));

		// total number of nodes in the graph (0 to 5)
		int n = 6;

		// build a directed graph from the given edges
		Graph graph = new Graph(edges, n);

		// find the root vertex in the graph
		int root = findRootVertex(graph, n);

		if (root != -1) {
			System.out.println("The root vertex is " + root);
		} else {
			System.out.println("The root vertex does not exist");
		}

	}

}
