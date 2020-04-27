package com.jasper.algs.leetcode.maths.qu0892.solu1;

/**
 * 0892. 三维形体的表面积
 * 
 * <p> 全6面，减去重叠面
 */
class Solution {
    public int surfaceArea(int[][] grid) {
    	int ans = 0;
    	
    	int N = grid.length;// N*N网格
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += grid[i][j]*6 //全6面
					- (grid[i][j]>1 ? (grid[i][j]-1)*2 : 0) // 上下面
					- (j < N-1 ? Math.min(grid[i][j+1], grid[i][j])*2 : 0)//左右侧面
					- (i < N-1 ? Math.min(grid[i+1][j], grid[i][j])*2 : 0);//前后侧面
			}
		}
		
    	return ans;
    }
}