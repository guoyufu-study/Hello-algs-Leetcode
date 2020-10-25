package com.jasper.algs.contest.weekly.c204.qu1568.solu1;

/**
 * 1568. 使陆地分离的最少天数
 * 
 * <p> 分类讨论 + DFS
 */
class Solution {
	
	int[] dx = new int[] {-1, 0, 0, 1};
	int[] dy = new int[] { 0,-1, 1, 0};
	
    public int minDays(int[][] grid) {
    	int n = grid.length, m = grid[0].length;
    	
    	// 0 全水、 >1 已分离
    	if(count(grid, n, m)!=1) return 0;
    	
    	// 1
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if(grid[i][j]==1) {
    				grid[i][j] = 0;
    				if(count(grid, n, m)!=1) return 1;
    				grid[i][j] = 1;
    			}
			}
			
		}
    	
    	return 2;
    }

	private int count(int[][] grid, int n, int m) {
		// 计数连通块
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j]==1) {
					cnt++;
					dfs(i, j, grid, n, m);
				}
			}
		}
		
		// 还原
		for(int i=0; i<n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j]==2) 
					grid[i][j]= 1;
			}
		}
		return cnt;
	}

	private void dfs(int i, int j, int[][] grid, int n, int m) {
		grid[i][j] = 2;// 标记
		for (int k = 0; k < 4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			if(0<=x&&x<n && 0<=y&&y<m && grid[x][y]==1) {
				dfs(x, y, grid, n, m);
			}
		}
	}
}