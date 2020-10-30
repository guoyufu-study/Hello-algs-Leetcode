package com.jasper.algs.leetcode.backtracing.qu0037.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0037. 解数独
 * 
 * <p> 回溯
 */
class Solution {
    public void solveSudoku(char[][] board) {
    	boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], rc = new boolean[9][9];
    	List<int[]> list = new ArrayList<>();
    	for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j]=='.')
					list.add(new int[] {i, j});
				else {
					int digit = board[i][j]-'1';
					rows[i][digit] = cols[j][digit] = rc[i/3+j/3*3][digit] = true;
				}
			}
		}
    	
    	dfs(board, list, 0, rows, cols, rc);
    }

	boolean dfs(char[][] board, List<int[]> list, int index, boolean[][] rows, boolean[][] cols, boolean[][] rc) {
		if(list.size()==index) return true;
		
		int[] xy = list.get(index);
		int x = xy[0], y = xy[1];
		for (int digit = 0; digit < 9; digit++) {
			if(!rows[x][digit] && !cols[y][digit] && !rc[x/3+y/3*3][digit]) {// .
				board[x][y] = (char)(digit+'1');
				rows[x][digit] = cols[y][digit] = rc[x/3+y/3*3][digit] = true;
				if(dfs(board, list, index+1, rows, cols, rc)) return true;
				board[x][y] = '.';
				rows[x][digit] = cols[y][digit] = rc[x/3+y/3*3][digit] = false;
			}
		}
		
		return false;
	}
}