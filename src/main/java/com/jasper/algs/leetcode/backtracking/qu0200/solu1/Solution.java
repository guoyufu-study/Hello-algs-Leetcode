package com.jasper.algs.leetcode.backtracking.qu0200.solu1;

/**
 * 0200. 岛屿数量
 *
 * <p> DFS 递归
 */
class Solution {
    public int numIslands(char[][] grid) {
    	
    	int M = grid.length;
    	// 边界
    	if(M<1) return 0;
    	int N = grid[0].length;
    	
    	int ans = 0;
    	for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				// 跳过水域
				if(grid[r][c] == '0') continue;
				
				// DFS 标记已遍历
				dfs(grid, M, N, r, c);
				
				// 统计岛屿数量
				ans++;
			}
		}
    	
    	return ans;
    }

    /**
     *  DFS 递归
     *  
     *  <p> 标记当前块所在岛屿的所有陆地块已遍历
     *  
     * @param grid	原始矩阵
     * @param M	行数
     * @param N	列数
     * @param r	当前块的行
     * @param c 当前块的列
     */
	private void dfs(char[][] grid, int M, int N, int r, int c) {
		// 终止
		if(r<0 || r>M-1 || c<0 || c>N-1 || grid[r][c]=='0')
			return ;
		
		// 标记已遍历
		grid[r][c] = '0';
		
		// DFS
		dfs(grid, M, N, r-1, c);
		dfs(grid, M, N, r+1, c);
		dfs(grid, M, N, r, c-1);
		dfs(grid, M, N, r, c+1);
	}
}