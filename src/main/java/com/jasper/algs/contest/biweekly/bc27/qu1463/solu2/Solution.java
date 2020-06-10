package com.jasper.algs.contest.biweekly.bc27.qu1463.solu2;

/**
 * 1463. 摘樱桃 II
 * 
 * <p> 动态规划
 */
class Solution {
	
	private int n ;
    public int cherryPickup(int[][] grid) {

    	int m = grid.length;
    	n = grid[0].length;
    	int[][][] dp = new int[m][n][n];
    	dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
    	
    	for (int i = 1; i < m; i++) {
    		int right = Math.min(i+1, n-1); // 机器人 1 能到达的最右侧位置
    		int left = Math.max(0, n-1-i); // 机器人 2 能到达的最右侧位置
			for (int j = 0; j < right; j++) {
				left = Math.max(left, j); // 令left>=j，机器人2 始终在机器人1 右侧
				for (int k = n-1; k >= left; k--) {
					dp[i][j][k] = getMax(dp, i-1, j, k) + grid[i][j] + grid[i][k];
					if(j==k)
						dp[i][j][k] -= grid[i][j];
				}
			}
		}
    	
    	// 找出最大值
    	int ans = 0;
    	for (int j = 0; j < n; j++) {
			for (int k = j; k < n; k++) {
				ans = Math.max(ans, dp[m-1][j][k]);
			}
		}
    	
    	return ans;
    }

    private int[] offsets = new int[] {-1, 0, 1};
    
	private int getMax(int[][][] dp, int i, int j, int k) {
		int ans = 0;
		for (int js : offsets) {
			int nj = j+js;
			if(nj<0) continue;
			if(nj>=n) break;
			for (int ks : offsets) {
				int nk = k + ks;
				if(nk<0) continue;
				if(nk>=n) break;
				ans = Math.max(ans, dp[i][nj][nk]);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };

		System.out.println(new Solution().cherryPickup(grid));
	}
}
