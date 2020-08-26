package com.jasper.algs.contest.biweekly.bc33.qu1559.solu1;

/**
 * 5482. 二维网格图中探测环
 * 
 * <p> DFS
 */
class Solution {
	
	int m, n;
	char[][] grid;
	int dist = 'a' - 'A';
	int[] offsetX = new int[] { 0, -1, 1, 0};
	int[] offsetY = new int[] {-1,  0, 0, 1};
    public boolean containsCycle(char[][] grid) {
    	m = grid.length;
    	n = grid[0].length;
    	this.grid = grid;
    	
    	if(m==1 || n==1) return false;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j]<'a') continue;
				if(dfs(i, j)) 
					return true;
			}
		}
    	
    	return false;
    }
	private boolean dfs(int i, int j) {
		char prev = grid[i][j];
		grid[i][j] -= dist; // 改成大写
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int x = i + offsetX[k];
			int y = j + offsetY[k];
			if(x>=0 && x<m && y>=0 && y<n) {
			    if(grid[x][y]==grid[i][j]) count++;
                else if(grid[x][y]==prev && dfs(x,y))
                    return true;
			}
		}
		
		if(count>=2) return true;
		
		return false;
	}
}