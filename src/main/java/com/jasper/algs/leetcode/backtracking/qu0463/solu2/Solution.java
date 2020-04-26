package com.jasper.algs.leetcode.backtracking.qu0463.solu2;

class Solution {
    public int islandPerimeter(int[][] grid) {
int M = grid.length;
    	
    	// 边界
    	if(M==0) return 0;
    	
    	int N = grid[0].length;
    	
    	int ans = 0;
		for (int r = 0; r < M; r++) { // rows 行
			for (int c = 0; c < N; c++) { // columns 列
				
				if(grid[r][c]==0) continue; // 跳过水域
				
				// 陆地 -> 计算
				ans += 4;// 4条边
				// 消边
				if(r>0 && grid[r-1][c]==1) ans -= 2;//上
				if(c>0 && grid[r][c-1]==1) ans -= 2;//左
			}
		}
		
    	return ans;
    }
}