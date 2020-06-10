package com.jasper.algs.contest.biweekly.bc27.qu1463.solu1;

/**
 * 1463. 摘樱桃 II
 * 
 * <p>
 * 记忆化DFS
 */
class Solution {
	
	private int[][] grid;
	private int rows, cols;
	private int[][][] memo;
	
	public int cherryPickup(int[][] grid) {
		this.grid = grid;
		rows = grid.length;
		cols = grid[0].length;
		memo = new int[rows][cols][cols];
		
		return dfs(0, 0, cols - 1);
	}

	private int dfs(int i, int j, int k) {
		if (i == rows) {
			return 0;
		}

		// 缓存
		if (memo[i][j][k] != 0)
			return memo[i][j][k];

		// 下一行
		for (int m = -1; m <= 1; m++) {
			int p = j + m;
			for (int n = -1; n <= 1; n++) {
				int q = k + n;
				if (p < 0 || p >= cols || q < 0 || q >= cols)
					continue;
				memo[i][j][k] = Math.max(memo[i][j][k], dfs(i + 1, p, q));
			}
		}

		memo[i][j][k] += grid[i][j];
		if (j != k) {
			memo[i][j][k] += grid[i][k];
		}
		
		return memo[i][j][k];
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };

		System.out.println(new Solution().cherryPickup(grid));
	}
}
