package com.gtm.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphTest {

	public void addEdge(List<List<Integer>> adj, int src, int dest) {
		adj.get(src).add(dest);
		adj.get(dest).add(src);
	}

	public void printGraph(List<List<Integer>> adj, int vertex) {
		for (int i = 0; i <= vertex; i++) {
			System.out.println("\nAdjacency list of vertex" + i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	/**
	 * predecessor -> If v is reachable from u, then u is a predecessor of v and v
	 * is a successor of u. If there is an arc from u to v, then u is a direct
	 * predecessor of v, and v is a direct successor of u.
	 * 
	 * @param args
	 */
	public boolean bfs(List<List<Integer>> adj, int src, int dest, int vertex, int[] predecessor, int[] dist,
			boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i <= vertex; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			predecessor[i] = -1;
		}

		visited[src] = true;
		dist[src] = 0;
		queue.add(src);

		while (!queue.isEmpty()) {
			int curr = queue.remove();
			for (int i = 0; i < adj.get(curr).size(); i++) {
				int neighbor = adj.get(curr).get(i);

				if (!visited[neighbor]) {
					visited[neighbor] = true;
					dist[neighbor] = dist[curr] + 1;
					predecessor[neighbor] = curr;
					queue.add(neighbor);
				}
				if (neighbor == dest) {
					return true;
				}
			}
		}
		return false;
	}

	public int minDistanceBWEdges(List<List<Integer>> adj, int src, int dest, int vertex, int[] predecessor, int[] dist,
			boolean[] visited) {

		boolean isReached = this.bfs(adj, src, dest, vertex, predecessor, dist, visited);

		if (isReached) {
			return (dist[dest] - dist[src]);
		}

		return -1;
	}

	public void dfs(List<List<Integer>> adj, int src, boolean[] visited) {
		visited[src] = true;
		for (int x : adj.get(src)) {
			if (!visited[x])
				dfs(adj, x, visited);
		}
	}

	public int noOfConnectedComponent(List<List<Integer>> adj, int vertex, boolean[] visited) {

		int components = 0;

		for (int i = 1; i <= vertex; i++) {
			if (!visited[i]) {
				components++;
				dfs(adj, i, visited);
			}
		}
		return components;
	}

	public List<Integer> dfcForGraph(List<List<Integer>> adj, int vertex) {
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[vertex + 1];
		for (int i = 1; i <= vertex; i++) {// if disconnected graph
			if (!visited[i]) {
				dfs(adj, i, visited, ans);
				// ans.add(null); //if disconnected graph and want to print new line
			}
		}
		// dfs(adj, i, visited, ans); // if connected graph
		return ans;
	}

	private void dfs(List<List<Integer>> adj, int src, boolean[] visited, List<Integer> ans) {
		visited[src] = true;
		ans.add(src);

		for (Integer neighbor : adj.get(src)) {
			if (!visited[neighbor]) {
				dfs(adj, neighbor, visited, ans);
			}
		}
	}

	public boolean isCycle(List<List<Integer>> adj, int vertex) {
		boolean[] visited = new boolean[vertex + 1];
		for (int v = 1; v <= vertex; v++) {
			if (!visited[v]) {
				if (dfsForCycle(adj, v, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfsForCycle(List<List<Integer>> adj, int v, boolean[] visited, int parent) {

		visited[v] = true;

		for (Integer neighbor : adj.get(v)) {
			if (!visited[neighbor]) {
				if (dfsForCycle(adj, neighbor, visited, v)) {
					return true;
				}
			} else if (parent != neighbor) {
				System.out.println("cycle b/w " + parent + " and " + neighbor);
				return true;
			}
		}

		return false;
	}

	static class Pair implements Comparable<Pair> {
		int wt;
		int v;

		public Pair(int wt, int v) {
			this.wt = wt;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}

	}

	public void dijkstra(List<List<Integer>> adj, int vertex, int startVertex) {
		boolean[] visited = new boolean[vertex + 1];
		int[] predecessor = new int[vertex + 1];
		int[] dist = new int[vertex + 1];
		for (int i = 0; i <= vertex; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			predecessor[i] = -1;
		}

		PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Pair(0, startVertex));
		dist[startVertex] = 0;
		while (!priorityQueue.isEmpty()) {
			Pair curr = priorityQueue.remove();
			int u = curr.v;
			if (visited[u]) {
				continue;
			}

			visited[u] = true;
			List<Integer> neighborsList = adj.get(u);

			for (Integer neighbor : neighborsList) {
				int wt = neighbor * 2 - u; // weight is not available in graph, if available use same
				if (dist[neighbor] > dist[u] + wt) {
					predecessor[neighbor] = u;
					dist[neighbor] = dist[u] + wt;
					priorityQueue.add(new Pair(dist[neighbor], neighbor));
				}

			}
		}
		printSolution(startVertex, dist, predecessor);

	}

	private void printSolution(int startVertex, int[] dist, int[] predecessor) {
		int nVertices = dist.length;
		System.out.print("Vertex\t Distance\tPath");

		for (int vertexIndex = 1; vertexIndex < nVertices; vertexIndex++) {
			if (vertexIndex != startVertex) {
				System.out.print("\n" + startVertex + " -> ");
				System.out.print(vertexIndex + " \t\t ");
				System.out.print(dist[vertexIndex] + "\t\t");
				printPath(vertexIndex, predecessor);
			}
		}

	}

	private void printPath(int currentVertex, int[] predecessor) {
		// Base case : Source node has
		// been processed
		if (currentVertex == -1) {
			return;
		}
		printPath(predecessor[currentVertex], predecessor);
		System.out.print(currentVertex + " ");

	}

	public void countShortestPath(List<List<Integer>> adj, int vertex, int source, int dest) {
		boolean[] visited = new boolean[vertex + 1];
		int[] predecessor = new int[vertex + 1];
		int[] dist = new int[vertex + 1];
		for (int i = 0; i <= vertex; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			predecessor[i] = -1;
		}

		PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Pair(0, source));
		dist[source] = 0;
		while (!priorityQueue.isEmpty()) {
			Pair curr = priorityQueue.remove();
			int u = curr.v;
			if (u == dest) {
				printShortestPath(source, dest, dist, predecessor);
			}
			if (visited[u]) {
				continue;
			}

			visited[u] = true;
			List<Integer> neighborsList = adj.get(u);

			for (Integer neighbor : neighborsList) {
				int wt = neighbor * 2 - u; // weight is not available in graph, if available use same
				if (dist[neighbor] > dist[u] + wt) {
					predecessor[neighbor] = u;
					dist[neighbor] = dist[u] + wt;
					priorityQueue.add(new Pair(dist[neighbor], neighbor));
				}

			}
		}

	}

	private void printShortestPath(int source, int dest, int[] dist, int[] predecessor) {
		System.out.print("Vertex\t Distance\tPath");
		System.out.print("\n" + source + " -> ");
		System.out.print(dest + " \t\t ");
		System.out.print(dist[dest] + "\t\t");
		printPath(dest, predecessor);
	}

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();
		int vertex = 8;
		int edge = 10;

		for (int i = 0; i <= vertex; i++) {
			adj.add(new ArrayList<>());
		}
		/*
		 * 1-> 2,5 2-> 3,4,5 3-> 4 4-> 5
		 */
		GraphTest graphTest = new GraphTest();
		graphTest.addEdge(adj, 1, 2);
		graphTest.addEdge(adj, 1, 5);
		graphTest.addEdge(adj, 2, 3);
		graphTest.addEdge(adj, 2, 4);
		graphTest.addEdge(adj, 2, 5);
		graphTest.addEdge(adj, 3, 4);
		graphTest.addEdge(adj, 4, 5);
		graphTest.addEdge(adj, 6, 7);
		graphTest.addEdge(adj, 7, 8);

		graphTest.printGraph(adj, vertex);

		boolean[] visited = new boolean[vertex + 1];
		int[] predecessor = new int[vertex + 1];
		int[] dist = new int[vertex + 1];

		// boolean isReached = graphTest.bfs(adj, 1, 4, vertex, predecessor, dist,
		// visited);
		// System.out.println(isReached);

		// System.out.println("Min dist :" + graphTest.minDistanceBWEdges(adj, 4, 1,
		// vertex, predecessor, dist, visited));

		// System.out.println("No of connected components :" +
		// graphTest.noOfConnectedComponent(adj, vertex, visited));

		/*
		 * System.out.println("DFS"); List<Integer> ans = graphTest.dfcForGraph(adj,
		 * vertex); System.out.println(ans);
		 */

		// System.out.println("Cycle " + graphTest.isCycle(adj, vertex));

		// graphTest.dijkstra(adj, vertex, 1);
		graphTest.countShortestPath(adj, vertex, 1, 5);
	}

}
