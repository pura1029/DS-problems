package com.gtm.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightGraphTest {

    private List<List<Pair>> adj;
    private int vertex;

    public WeightGraphTest(int v) {
        this.vertex = v;
        this.adj = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            adj.add(new ArrayList<>());
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "v=" + v +
                    ", wt=" + wt +
                    '}';
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Pair(dest, weight));
        adj.get(dest).add(new Pair(src, weight));
    }

    public void printGraph() {
        for (int i = 0; i <= vertex; i++) {
            System.out.println("\nAdjacency list of vertex: " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    //https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    // Find the shortest path of all vertices form start Vertex.
    public void dijkstra(int startVertex) {
        boolean[] visited = new boolean[vertex + 1];
        int[] predecessor = new int[vertex + 1];// store parent of current node
        int[] dist = new int[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(startVertex, 0));
        dist[startVertex] = 0;
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();
            int u = curr.v;
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            List<Pair> neighborsList = adj.get(u);

            for (Pair neighbor : neighborsList) {
                int wt = neighbor.wt;
                int u1 = neighbor.v;
                if (dist[u1] > dist[u] + wt) {
                    predecessor[u1] = u;
                    int currNodeDist = dist[u] + wt;
                    dist[u1] = currNodeDist;
                    priorityQueue.add(new Pair(u1, currNodeDist));
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

    // Count the all shortest path form source to destination Vertex.
    public void countShortestPath(int source, int dest) {
        boolean[] visited = new boolean[vertex + 1];
        int[] dist = new int[vertex + 1];
        int[] path = new int[vertex + 1];// store no of Shortest Path of current node.
        for (int i = 0; i <= vertex; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            path[i] = 0;
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(source, 0));
        dist[source] = 0;
        path[source] = 1;
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();
            int u = curr.v;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            List<Pair> neighborsList = adj.get(u);

            for (Pair neighbor : neighborsList) {
                int wt = neighbor.wt;
                int u1 = neighbor.v;
                if (dist[u1] > dist[u] + wt) {
                    path[u1] = path[u];
                    dist[u1] = dist[u] + wt;
                    priorityQueue.add(new Pair(u1, dist[u1]));
                } else if (dist[u1] == dist[u] + wt) {
                    path[u1] = (path[u1] + path[u]);
                }

            }
        }

        printShortestPath(source, dest, path, dist);

    }

    private void printShortestPath(int source, int dest, int[] path, int[] dist) {
        System.out.println();
        System.out.print("Vertex\t Count of Path\t Distance");
        System.out.print("\n" + source + " -> ");
        System.out.print(dest + " \t\t ");
        System.out.print(path[dest] + "\t\t\t\t");
        System.out.print(dist[dest] + "\t\t");
    }

    public static void main(String[] args) {
        int vertex = 8;
        int edge = 10;
        /*
         * 1-> 2,5 2-> 3,4,5 3-> 4 4-> 5
         */
        WeightGraphTest graphTest = new WeightGraphTest(vertex);
        graphTest.addEdge(1, 2, 5);
        graphTest.addEdge(1, 5, 6);
        graphTest.addEdge(2, 3, 4);
        graphTest.addEdge(2, 4, 10);
        graphTest.addEdge(2, 5, 1);
        graphTest.addEdge(3, 4, 12);
        graphTest.addEdge(4, 5, 7);
        graphTest.addEdge(5, 6, 2);// remove to break graph
        graphTest.addEdge(6, 7, 3);
        graphTest.addEdge(7, 8, 5);

        graphTest.printGraph();
        graphTest.dijkstra(1);
        graphTest.countShortestPath(1, 5);

        boolean[] visited = new boolean[vertex + 1];
        int[] predecessor = new int[vertex + 1];
        int[] dist = new int[vertex + 1];
    }

}
