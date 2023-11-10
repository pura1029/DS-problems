package com.gtm.ds.graph2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    //https://leetcode.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfsForNumIslands(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfsForNumIslands(char grid[][], int row, int col, int visited[][]) {
        visited[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        /**
         *          (r-1,c)
         *  (r,c-1) (r,c) (r,c+1)
         *         (r+1,c)
         */

        int delrow[] = {-1, 0, 1, 0};// Array to represent possible row moves (up, right, down, left)
        int delcol[] = {0, 1, 0, -1};// Array to represent possible column moves (up, right, down, left)
        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                // Recursively call DFS on the adjacent cell
                dfsForNumIslands(grid, nrow, ncol, visited);
            }
        }
    }

    //https://leetcode.com/problems/rotting-oranges/
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        int[][] vis = new int[n][m];
        int countFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) countFresh++;
            }
        }
        int tm = 0;
        int[] drow = {-1, 0, 1, 0};// Array to represent possible row moves (up, right, down, left)
        int[] dcol = {0, 1, 0, -1};// Array to represent possible column moves (up, right, down, left)
        int cnt = 0;
        while (!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            tm = Math.max(tm, t);
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = r + drow[i];
                int nCol = c + dcol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol, t + 1));
                    vis[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != countFresh) return -1;
        return tm;
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

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("num of Islands :" + graphTest.numIslands(grid));

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("time for orangesRotting :" + graphTest.orangesRotting(grid1));

        //Directed graph
        int v1 = 4;
        GraphTest directedGraphTest = new GraphTest(v1);
        directedGraphTest.createDirectedGraph();

        System.out.println("is cycle:" + directedGraphTest.detectCycleinDirectedGraph(0, new boolean[v1], new boolean[v1]));
    }

    class Pair {
        int row;
        int col;
        int tm;

        Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
}
