package com.jasper.algs.leetcode.backtracing.qu0130.solu3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0130. 被围绕的区域
 *
 * <p> bfs
 */
class Solution {

	// 偏移量
	int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
    	// 边界
        int n = board.length;
        if(n <= 2) return ;
        int m = board[0].length;
        if(m <= 2) return ;
        
        // 着色边界上的O
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {// 左列
                queue.offer(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {// 右列
                queue.offer(new int[]{i, m - 1});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {// 首行
                queue.offer(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {// 尾行
                queue.offer(new int[]{n - 1, i});
            }
        }
        // 着色与边界上的O相连的O
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            board[x][y] = 'A'; // 着色
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
            }
        }
        
        // 构造答案
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}