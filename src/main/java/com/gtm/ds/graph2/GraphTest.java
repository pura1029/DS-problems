package com.gtm.ds.graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class GraphTest {

    @AllArgsConstructor
    @Getter
    static class Edge {
        private int src;
        private int desc;
    }

    public static void addEdge(List<List<Edge>> graph, int i, int src, int desc) {
        List<Edge> edges = null;
        if (i < graph.size()) {
            edges = graph.get(i);
        } else {
            edges = new ArrayList<>();
        }


        edges.add(new Edge(src, desc));
        graph.add(edges);
    }

    public static void createGraph(List<List<Edge>> graph) {

        addEdge(graph, 0, 0, 1);
        addEdge(graph, 0, 0, 2);

        addEdge(graph, 1, 1, 0);
        addEdge(graph, 1, 1, 3);

        addEdge(graph, 2, 2, 0);
        addEdge(graph, 2, 2, 4);

        addEdge(graph, 3, 3, 1);
        addEdge(graph, 3, 3, 4);
        addEdge(graph, 3, 3, 5);

        addEdge(graph, 4, 4, 2);
        addEdge(graph, 4, 4, 3);
        addEdge(graph, 4, 4, 5);

        addEdge(graph, 5, 5, 3);
        addEdge(graph, 5, 5, 4);
        addEdge(graph, 5, 5, 6);

        addEdge(graph, 6, 6, 5);
    }


    public static void bfs(List<List<Edge>> graph, int V, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph.get(curr).size(); i++) {
                    Edge edge = graph.get(curr).get(i);
                    queue.add(edge.getDesc());
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int V = 7;
        List<List<Edge>> graph = new ArrayList<>(V);
        createGraph(graph);

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(graph, V, visited, i);
            }
        }

    }

}
