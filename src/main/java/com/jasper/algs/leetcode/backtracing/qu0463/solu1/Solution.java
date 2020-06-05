package com.jasper.algs.leetcode.backtracing.qu0463.solu1;

/**
 * 0463. 岛屿的周长
 *
 *	<p> 深度优先搜索
 */
class Solution {
	
    public int islandPerimeter(int[][] grid) {
    	int M = grid.length;
    	
    	// 边界
    	if(M==0) return 0;
    	
    	int N = grid[0].length;
    	
		for (int r = 0; r < M; r++) { // rows 行
			for (int c = 0; c < N; c++) { // columns 列
				
				if(grid[r][c]==0) continue; // 跳过水域
				
				// 陆地 -> DFS 只有一个岛屿
				return dfs(grid, M, N, r, c);
			}
		}
		
    	return 0;
    }

	private int dfs(int[][] grid, int M, int N, int r, int c) {
		if(r<0 || r>M-1 || c<0 || c>N-1 || grid[r][c]==0) {//从一个岛屿方格走向一个非岛屿方格
			return 1;
		}
		
		// 跳过已遍历岛屿方格
		if(grid[r][c]==2) return 0;
		grid[r][c] = 2;// 标记已遍历岛屿方格
		
		return dfs(grid, M, N, r-1, c)//上
				+ dfs(grid, M, N, r+1, c)//下
				+ dfs(grid, M, N, r, c-1)//左
				+ dfs(grid, M, N, r, c+1);//右
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {{1}};
		
		System.out.println(new Solution().islandPerimeter(grid));
	}
}