package com.gtm.ds.graph2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.youtube.com/watch?v=59fUtYYz7ZU&list=PLfqMhTWNBTe0sPLFF91REaJQEteFZtLzA&index=15&ab_channel=ApnaCollege
public class GraphTest {

    private List<List<Edge>> graph;
    private int V;

    public GraphTest(int v) {
        this.graph = new ArrayList<>(v);
        this.V = v;
        for (int i = 0; i < V; i++) {
            List<Edge> edges = new ArrayList<>();
            graph.add(edges);
        }
    }

    @AllArgsConstructor
    @Getter
    static class Edge {
        private int src;
        private int dest;
        private int wt;
    }

    public void addEdge(int index, int src, int desc, int wt) {
        List<Edge> edges = graph.get(index);
        edges.add(new Edge(src, desc, wt));
    }

    public void createGraph() {

        addEdge(0, 0, 1, 1);
        addEdge(0, 0, 2, 2);

        addEdge(1, 1, 0, 2);
        addEdge(1, 1, 3, 1);

        addEdge(2, 2, 0, -1);
        addEdge(2, 2, 4, 3);

        addEdge(3, 3, 1, 4);
        addEdge(3, 3, 4, 1);
        addEdge(3, 3, 5, 5);

        addEdge(4, 4, 2, 2);
        addEdge(4, 4, 3, 3);
        addEdge(4, 4, 5, 1);

        addEdge(5, 5, 3, -1);
        addEdge(5, 5, 4, -2);
        addEdge(5, 5, 6, 4);

        addEdge(6, 6, 5, 5);
    }

    public void createDirectedGraph() {
        addEdge(0, 0, 2, 1);

        addEdge(1, 1, 0, 2);

        addEdge(2, 2, 3, -1);

        addEdge(3, 3, 0, 4);
    }

    public void bfs(boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph.get(curr).size(); i++) {
                    Edge edge = graph.get(curr).get(i);
                    queue.add(edge.getDest());
                }
            }
        }
    }

    public void dfs(int curr, boolean[] visited) {

        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge edge = graph.get(curr).get(i);
            if (!visited[edge.getDest()]) {
                dfs(edge.dest, visited);
            }
        }
    }

    public boolean detectCycleinDirectedGraph(int curr, boolean[] visited, boolean[] stack) {

        stack[curr] = true;
        visited[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge edge = graph.get(curr).get(i);
            if (stack[edge.getDest()]) {
                return true;
            }
            if (!visited[edge.getDest()] && detectCycleinDirectedGraph(edge.dest, visited, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public boolean detectCycleinUnDirectedGraph(int curr, boolean[] visited, int parent) {

        visited[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge edge = graph.get(curr).get(i);
            if (visited[edge.getDest()] && edge.getDest() != parent) {
                System.out.println("cycle b/w " + parent + " and " + edge.getDest());
                return true;
            } else if (!visited[edge.getDest()] && detectCycleinUnDirectedGraph(edge.getDest(), visited, curr)) {
                return true;
            }
        }
        return false;
    }

    public void printAllPath(int curr, int target, String path, boolean[] visited) {

        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge edge = graph.get(curr).get(i);
            if (!visited[edge.getDest()]) {
                visited[curr] = true;
                printAllPath(edge.dest, target, (path + "->" + edge.getDest()), visited);
                visited[curr] = false;
            }
        }

    }

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", dist=" + dist +
                    '}';
        }
    }

    public void dijkstra(int src) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] predecessor = new int[V];// store parent of current node
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        priorityQueue.add(new Pair(src, 0));
        dist[src] = 0;
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.remove();
            if (!visited[pair.node]) {
                visited[pair.node] = true;
                for (int i = 0; i < graph.get(pair.node).size(); i++) {
                    Edge edge = graph.get(pair.node).get(i);
                    int u = edge.src;
                    int v = edge.dest;
                    if (dist[u] + edge.wt < dist[v]) {
                        dist[v] = dist[u] + edge.wt;
                        priorityQueue.add(new Pair(v, dist[v]));
                        predecessor[v] = pair.node;
                    }
                }
            }
        }
        printSolution(src, dist, predecessor);
    }

    private void printSolution(int src, int[] dist, int[] predecessor) {
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < V; vertexIndex++) {
            if (vertexIndex != src) {
                System.out.print("\n" + src + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(dist[vertexIndex] + "\t\t");
                //printPath(src, vertexIndex, predecessor);
            }
        }

    }

    private void printPath(int src, int currentVertex, int[] predecessor) {
        // Base case : Source node has
        // been processed
        if (currentVertex == -1 || currentVertex == src) {
            return;
        }
        printPath(src, predecessor[currentVertex], predecessor);
        System.out.print(currentVertex + " ");

    }

    public static void main(String[] args) {
        int V = 7;
        GraphTest graphTest = new GraphTest(V);
        graphTest.createGraph();

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                //graphTest.bfs(graph, visited, i); // Time complexity : O(V+E)
                graphTest.dfs(i, visited);
            }
        }
        System.out.println();

        int src = 0;
        int dest = 5;

        visited = new boolean[V];
        graphTest.printAllPath(src, dest, ("" + src), visited);

        //Directed graph
        int v1 = 4;
        GraphTest directedGraphTest = new GraphTest(v1);
        directedGraphTest.createDirectedGraph();

        System.out.println("is cycle:" + directedGraphTest.detectCycleinDirectedGraph(0, new boolean[v1], new boolean[v1]));

        graphTest.dijkstra(0);
    }
}
