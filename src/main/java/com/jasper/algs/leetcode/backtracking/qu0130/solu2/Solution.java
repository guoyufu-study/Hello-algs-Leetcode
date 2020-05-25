package com.jasper.algs.leetcode.backtracking.qu0130.solu2;

import java.util.Stack;

/**
 * 0130. 被围绕的区域
 *
 * <p> DFS 非递归
 */
class Solution {
	
	// 行列
	private int m = 0, n = 0;
	// 偏移量
	private int[][] offset = new int[][] {
		{-1,0}, {1,0},//上下
		{0,-1}, {0,1},//左右
		};
		
    public void solve(char[][] board) {
    	// 边界
    	if(board==null || board.length<=2 || board[0].length<=2)
    		return ;
    	
    	m = board.length;
    	n = board[0].length;
    	
    	// 着色与边界连通的O
    	Stack<int[]> helper = new Stack<>();
    	// 左右边界
    	for (int i = 0; i < m; i++) {
    		if(board[i][0]=='O') dfs(board, i, 0, helper);
    		if(board[i][n-1]=='O') dfs(board, i, n-1, helper);
		}
    	// 上下边界
    	for (int j = 0; j < n; j++) {
    		if(board[0][j]=='O') dfs(board, 0, j, helper);
    		if(board[m-1][j]=='O') dfs(board, m-1, j, helper);
    	}
    	
    	// 构造结果
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j]=='O') board[i][j] = 'X';
				else if(board[i][j]=='#') board[i][j] = 'O';
			}
		}
    }

	private void dfs(char[][] board, int i, int j, Stack<int[]> helper) {
		
		helper.push(new int[] {i, j});
		while(!helper.isEmpty()) {
			int[] pop = helper.pop();
			i = pop[0];
			j = pop[1];
			// 跳过
			if(!isValid(i,j) || board[i][j]=='X' || board[i][j]=='#') continue;
			// 着色
			board[i][j] = '#';
			// 下一个
			for (int off = 0; off < 4; off++) {
				helper.push(new int[] {i+offset[off][0], j+offset[off][1]});
			}
		}
		
	}

	private boolean isValid(int i, int j) {
		return i>=0 && i<=m-1 
				&& j>=0 && j<=n-1;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][] {
			{'X','X','X','X'},
			{'X','O','O','X'},
			{'X','X','O','X'},
			{'X','O','X','X'}};
			
		new Solution().solve(board);
	}
}