package com.gtm.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// A class to store a graph edge
class Edge {
	int source;
	int dest;

	public Edge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
}

// A class to represent a graph object
class Graph {
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge : edges) {
			int src = edge.source;
			int dest = edge.dest;

			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
	}
}

public class GraphTest1 {
	// Perform BFS on the graph starting from vertex `v`
	public static void bfs(Graph graph, int v, boolean[] discovered) {
		// create a queue for doing BFS
		Queue<Integer> q = new ArrayDeque<>();

		// mark the source vertex as discovered
		discovered[v] = true;

		// enqueue source vertex
		q.add(v);

		// loop till queue is empty
		while (!q.isEmpty()) {
			// dequeue front node and print it
			v = q.poll();
			System.out.print(v + " ");

			// do for every edge (v, u)
			for (int u : graph.adjList.get(v)) {
				if (!discovered[u]) {
					// mark it as discovered and enqueue it
					discovered[u] = true;
					q.add(u);
				}
			}
		}
	}

	// Perform BFS recursively on the graph
	public static void recursiveBFS(Graph graph, Queue<Integer> q, boolean[] discovered) {
		if (q.isEmpty()) {
			return;
		}

		// dequeue front node and print it
		int v = q.poll();
		System.out.print(v + " ");

		// do for every edge (v, u)
		for (int u : graph.adjList.get(v)) {
			if (!discovered[u]) {
				// mark it as discovered and enqueue it
				discovered[u] = true;
				q.add(u);
			}
		}

		recursiveBFS(graph, q, discovered);
	}

	// Function to perform DFS traversal on the graph on a graph
	public static void dfs(Graph graph, int v, boolean[] discovered) {
		// mark the current node as discovered
		discovered[v] = true;

		// print the current node
		System.out.print(v + " ");

		// do for every edge (v, u)
		for (int u : graph.adjList.get(v)) {
			// if `u` is not yet discovered
			if (!discovered[u]) {
				dfs(graph, u, discovered);
			}
		}
	}

	// Perform iterative DFS on graph starting from vertex `v`
	public static void iterativeDFS(Graph graph, int v, boolean[] discovered) {
		// create a stack used to do iterative DFS
		Stack<Integer> stack = new Stack<>();

		// push the source node into the stack
		stack.push(v);

		// loop till stack is empty
		while (!stack.empty()) {
			// Pop a vertex from the stack
			v = stack.pop();

			// if the vertex is already discovered yet, ignore it
			if (discovered[v]) {
				continue;
			}

			// we will reach here if the popped vertex `v` is not discovered yet;
			// print `v` and process its undiscovered adjacent nodes into the stack
			discovered[v] = true;
			System.out.print(v + " ");

			// do for every edge (v, u)
			List<Integer> adjList = graph.adjList.get(v);
			for (int i = adjList.size() - 1; i >= 0; i--) {
				int u = adjList.get(i);
				if (!discovered[u]) {
					stack.push(u);
				}
			}
		}
	}

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
		List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5), new Edge(2, 6),
				new Edge(5, 9), new Edge(5, 10), new Edge(4, 7), new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
		// vertex 0, 13, and 14 are single nodes
		);

		// total number of nodes in the graph (labelled from 0 to 14)
		int n = 15;

		// build a graph from the given edges
		Graph graph = new Graph(edges, n);

		// to keep track of whether a vertex is discovered or not
		boolean[] discovered = new boolean[n];

		// Perform BFS traversal from all undiscovered nodes to
		// cover all connected components of a graph
		for (int i = 0; i < n; i++) {
			if (!discovered[i]) {
				// start BFS traversal from vertex `i`
				bfs(graph, i, discovered);
			}
		}

		System.out.println("\nrecursiveBFS");
		// to keep track of whether a vertex is discovered or not
		boolean[] discovered1 = new boolean[n];

		// create a queue for doing BFS
		Queue<Integer> q = new ArrayDeque<>();

		// Perform BFS traversal from all undiscovered nodes to
		// cover all connected components of a graph
		for (int i = 0; i < n; i++) {
			if (!discovered1[i]) {
				// mark the source vertex as discovered
				discovered1[i] = true;

				// enqueue source vertex
				q.add(i);

				// start BFS traversal from vertex `i`
				recursiveBFS(graph, q, discovered1);
			}
		}

		System.out.println("\ndfs-----------");

		// to keep track of whether a vertex is discovered or not
		boolean[] discovered2 = new boolean[n];

		// Perform DFS traversal from all undiscovered nodes to
		// cover all connected components of a graph
		for (int i = 0; i < n; i++) {
			if (!discovered2[i]) {
				dfs(graph, i, discovered2);
			}
		}
		
		
		System.out.println("\niterativeDFS");
		// to keep track of whether a vertex is discovered or not
        boolean[] discovered3 = new boolean[n];
 
        // Do iterative DFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < n; i++)
        {
            if (!discovered3[i]) {
                iterativeDFS(graph, i, discovered3);
            }
        }
	}
}