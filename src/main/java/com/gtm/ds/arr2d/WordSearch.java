/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.arr2d;

/**
 * https://leetcode.com/problems/word-search/description/
 * <br/>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.</p>
 *
 * @author kumargautam
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean res = dfs(board, word, i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int wIndex) {
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row == rows || col < 0 || col == cols) {
            return false;
        }
        if (board[row][col] != word.charAt(wIndex) || board[row][col] == '1') {
            return false;
        }
        if (wIndex == word.length() - 1) {
            return true;
        }
        char cache = board[row][col];
        // same letter cell may not be used more than once
        board[row][col] = '1';
        // search down, up, left, right
        boolean res = dfs(board, word, row + 1, col, wIndex + 1) || dfs(board, word, row - 1, col, wIndex + 1) ||
                dfs(board, word, row, col + 1, wIndex + 1) || dfs(board, word, row, col - 1, wIndex + 1);
        // update the actual letter cell
        board[row][col] = cache;
        return res;
    }

    public boolean exist1(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (word.charAt(0) == board[i][j] && wordSearch(i, j, 0, word, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordSearch(int i, int j, int index, String word, char[][] board, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
                visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (wordSearch(i + 1, j, index + 1, word, board, visited) ||
                wordSearch(i - 1, j, index + 1, word, board, visited) ||
                wordSearch(i, j + 1, index + 1, word, board, visited) ||
                wordSearch(i, j - 1, index + 1, word, board, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

        char[][] board1 = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word1 = "SEE";
        System.out.println(exist(board1, word1));

        char[][] board2 = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word2 = "ABCB";
        System.out.println(exist(board2, word2));
    }
}
