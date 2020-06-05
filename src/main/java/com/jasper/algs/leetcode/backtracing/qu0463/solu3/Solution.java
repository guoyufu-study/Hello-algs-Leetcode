package com.jasper.algs.leetcode.backtracing.qu0463.solu3;

/**
 * 0463. 岛屿的周长
 *
 *	<p> 只算半边
 */
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
				
				
				// 陆地 -> 计算与水域相接的上边及左边
				if(r==0 || grid[r-1][c]==0) ans++;//上边
				if(c==0 || grid[r][c-1]==0) ans++;//左边
			}
		}
		
    	return ans*2;
    }
}