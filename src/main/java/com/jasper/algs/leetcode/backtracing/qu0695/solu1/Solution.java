package com.jasper.algs.leetcode.backtracing.qu0695.solu1;

/**
 * 0695. 岛屿的最大面积
 *
 *	<p>DFS 深度优先搜索
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    	
    	int M = grid.length;
    	if(M<1) return 0; // 边界
    	int N = grid[0].length;
    	
    	int ans = 0;
    	for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if(grid[r][c]==0) continue; // 跳过水域
				
				// 计算岛屿面积
				int areaOfIsland = dfs(grid, M, N, r, c);
				
				// 更新最大岛屿面积
				if(ans < areaOfIsland)
					ans = areaOfIsland;
			}
		}
    	
    	return ans;
    }

    /**
     * DFS 深度优先搜索，统计岛屿面积
     * 
     * @param grid
     * @param r 当前块的行
     * @param c 当前块的列
     * @return
     */
	private int dfs(int[][] grid, int M, int N, int r, int c) {
		
		//终止
		if(r<0 || r>M-1 || c<0 || c> N-1 || grid[r][c]==0) // 不是陆地块
			return 0;
		
		// 标记已遍历岛屿
		grid[r][c] = 0;
		
		// 岛屿面积+1
		return dfs(grid, M, N, r-1, c)
				+ dfs(grid, M, N, r+1, c)
				+ dfs(grid, M, N, r, c-1)
				+ dfs(grid, M, N, r, c+1)
				+ 1;
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,0,1,1},
				{0,0,0,1,1}};
		
		System.out.println(new Solution().maxAreaOfIsland(grid));
	}
}