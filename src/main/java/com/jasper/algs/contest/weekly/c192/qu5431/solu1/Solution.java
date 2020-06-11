package com.jasper.algs.contest.weekly.c192.qu5431.solu1;

/**
 * 5431. 给房子涂色 III
 * 
 * <p> 动态规划
 */
class Solution {
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

		// dp[i][j][k] 表示 第 i 个房子涂 k 色，涂完前 i 个房子，得到 j 个街区，所有方案的 cost 最小值。
		// 房子从0开始，街区从1开始，颜色从1开始
		int[][][] dp = new int[m][target + 1][n + 1];
		
		// 初始化
		final int INF = 1_000_001; // 表示无方案
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < target + 1; j++) {
				for (int k = 0; k < n + 1; k++) {
					dp[i][j][k] = INF;
				}
			}
		}

		// 初始化第0个房子
		if (houses[0] > 0) // 第0个房子已经涂色
			dp[0][1][houses[0]] = 0;

		else // 第0个房子没有涂色，涂颜色 i
			for (int i = 1; i <= n; i++) {
				dp[0][1][i] = cost[0][i - 1];
			}

		// 状态转移时涂色完第i个房子。
		for (int i = 1; i < m; i++) {
			// 最多T个街区
			int T = Math.min(target, i+1);
			for (int j = 1; j <= T; j++) {
				// 第i个房子已经涂色：前 i-1 个房子涂色最小花费
				if (houses[i] > 0) {
					int temp = houses[i];
					for (int k = 1; k <= n; k++) {
						// 与前一房子同色，同街区
						if (temp == k) {
							dp[i][j][temp] = Math.min(dp[i][j][temp], dp[i - 1][j][k]);
						} 
						// 与前一房子不同色，自成一个街区
						else {
							dp[i][j][temp] = Math.min(dp[i][j][temp], dp[i - 1][j - 1][k]);
						}
					}
				} 
				// 第i个房子没有涂色
				else {
					for (int k = 1; k <= n; k++) { // 涂 k 色
						for (int s = 1; s <= n; s++) { // 前一个房子涂了 s 色
							// 与前一房子同色，同街区
							if (k == s) {
								dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][s] + cost[i][k - 1]);
							} 
							// 与前一房子不同色，自成一个街区
							else {
								dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][s] + cost[i][k - 1]);
							}
						}
					}

				}
			}
		}

		int ans = INF;
		for (int i = 1; i <= n; i++) {
			ans = Math.min(ans, dp[m - 1][target][i]);
		}
			
		return ans == INF ? -1 : ans;

	}

	public static void main(String[] args) {
		// 9
//    	int[] houses = new int[] {0,0,0,0,0};
//    	int[][] cost = new int[][] {{1,10},{10,1},{10,1},{1,10},{5,1}}; 
//    	int m = 5; 
//    	int n = 2;
//    	int target = 3;

		// 5
//    	int[] houses = new int[] {0,0,0,0,0};
//    	int[][] cost = new int[][] {{1,10},{10,1},{1,10},{10,1},{1,10}};
//    	int m = 5;
//    	int n = 2;
//    	int target = 5;

		// 11
		int[] houses = new int[] { 0, 2, 1, 2, 0 };
		int[][] cost = new int[][] { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } };
		int m = 5;
		int n = 2;
		int target = 3;

		System.out.println(new Solution().minCost(houses, cost, m, n, target));
	}
}