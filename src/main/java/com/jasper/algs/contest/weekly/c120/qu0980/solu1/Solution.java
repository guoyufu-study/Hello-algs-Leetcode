package com.jasper.algs.contest.weekly.c120.qu0980.solu1;

/**
 * 0980.不同路径 III
 * 
 * <p> 回溯 DFS
 */
class Solution {

	private int ans;
	private boolean[][] visited;
	private int n, m, steps, startI, startJ;
	private int[] offsetX = new int[] {-1, 0, 0, 1},
				  offsetY = new int[] { 0,-1, 1, 0};
	public int uniquePathsIII(int[][] grid) {
		
		n = grid.length;
		m = grid[0].length;
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j]==-1)
					visited[i][j] = true;
				else if(grid[i][j]==0)
					steps++;
				else if(grid[i][j]==1) {
					startI = i;
					startJ = j;
				}
			}
		}
    	
		dfs(grid, startI, startJ, 0);
		
		return ans;
    }
	private void dfs(int[][] grid, int i, int j, int count) {
		if(grid[i][j]==2) {
			ans += count == steps + 1 ? 1 : 0;
			return ;
		}
			
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			int x = i + offsetX[k];
			int y = j + offsetY[k];
			if(x<0 || x>=n || y<0 || y>=m || visited[x][y]) continue;
			dfs(grid, x, y, count+1);
			
		}
		
		visited[i][j] = false;
	}
	
	public static void main(String[] args) {
		// 
		int[][] grid = new int[][] {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		
		System.out.println(new Solution().uniquePathsIII(grid));
	}

}