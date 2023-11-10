/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.graph2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Insert your comment for {@link GraphProblems}.
 *
 * @author kumargautam
 */
public class GraphProblems {

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

    static class Pair {
        int row;
        int col;
        int tm;

        Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
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
        GraphProblems graphTest = new GraphProblems();
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
    }
}
