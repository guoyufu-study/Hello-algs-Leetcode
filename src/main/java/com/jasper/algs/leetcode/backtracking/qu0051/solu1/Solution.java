package com.jasper.algs.leetcode.backtracking.qu0051.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0051. N皇后
 *
 * <p> 回溯 + 计数标记
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {

    	List<List<String>> ans = new ArrayList<>();

    	backtrack(n, new int[n][n], 0, new int[n], ans);
    	
    	return ans;
    }

	private void backtrack(int n, int[][] flags, int row, int[] path, List<List<String>> ans) {
		// 终止条件
		if(row==n) {
			List<String> list = new ArrayList<String>();
			for (int r = 0; r < n; r++) {
				char[] tmp = new char[n];
				Arrays.fill(tmp, '.');
				tmp[path[r]] = 'Q';
				list.add(new String(tmp));
			}
			ans.add(list);
			return ;
		}
		
		for (int col = 0; col < n; col++) {
			// 跳过已占用
			if(flags[row][col] != 0) continue;
			
			// 选择，并标记
			path[row]=col;
			flag(n, flags, row, col);
			
			// 选择下一个
			backtrack(n, flags, row+1, path, ans);
			
			// 回溯
			path[row]=0;
			unflag(n, flags, row, col);
		}
	
	}

	private void unflag(int n, int[][] flags, int row, int col) {
		// 第row行
		for (int i = 0; i < n; i++) flags[row][i]--;
		
		// 第col列
		for (int i = 0; i < n; i++) flags[i][col]--;
		
		// row+col
		int sum = row+col;
		int i = 0, j = sum;
		if(sum<n)
			while(j>=0) flags[i++][j--]--;
		else {
			i=n-1; j= sum-i;
			while(j<n) flags[i--][j++]--;
		}
		
		// row-col
		int sub = row-col;
		if(row>=col) {
			i=n-1; j=i-sub;
			while(j>=0) flags[i--][j--]--;
		} else {
			i=0; j=i-sub;
			while(j<n) flags[i++][j++]--;
		}
		
		flags[row][col]+=3;
	}

	private void flag(int n, int[][] flags, int row, int col) {
		// 第row行
		for (int i = 0; i < n; i++) flags[row][i]++;
		
		// 第col列
		for (int i = 0; i < n; i++) flags[i][col]++;
		
		// row+col
		int sum = row+col;
		int i = 0, j = sum;
		if(sum<n)
			while(j>=0) flags[i++][j--]++;
		else {
			i=n-1; j= sum-i;
			while(j<n) flags[i--][j++]++;
		}
		
		// row-col
		int sub = row-col;
		if(row>=col) {
			i=n-1; j=i-sub;
			while(j>=0) flags[i--][j--]++;
		} else {
			i=0; j=i-sub;
			while(j<n) flags[i++][j++]++;
		}
		
		flags[row][col]-=3;
	}
	
	public static void main(String[] args) {
		int n = 4;
		new Solution().solveNQueens(n);
	}
}