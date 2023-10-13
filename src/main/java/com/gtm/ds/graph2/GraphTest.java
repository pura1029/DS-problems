package com.gtm.ds.graph2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTest {

    private List<List<Edge>> graph;
    private int V;

    public GraphTest(int v) {
        this.graph = new ArrayList<>(v);
        this.V = v;
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

        for (int i = 0; i < V; i++) {
            List<Edge> edges = new ArrayList<>();
            graph.add(edges);
        }

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

    public static void main(String[] args) {
        int V = 7;
        GraphTest graphTest = new GraphTest(V);
        graphTest.createGraph();

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                //graphTest.bfs(graph, visited, i);
                graphTest.dfs(i, visited);
            }
        }
        System.out.println();

        int src = 0;
        int dest = 5;

        visited = new boolean[V];
        graphTest.printAllPath(src, dest, ("" + src), visited);
    }

}
