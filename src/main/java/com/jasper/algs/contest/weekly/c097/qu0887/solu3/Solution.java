package com.jasper.algs.contest.weekly.c097.qu0887.solu3;

/**
 * 0887. 鸡蛋掉落
 * 
 * <p> 动态规划  + 决策单调性
 */
class Solution {
	public int superEggDrop(int K, int N) {
		// 动态规划
		int[][] dp = new int[K+1][N+1];
		for (int n = 1; n <= N; n++) dp[1][n] = n;//// 1个鸡蛋 n 层楼
		
		for (int k = 2; k <= K; k++) {
			int x = 1;
			for (int n = 1; n <= N; n++) {
				// 决策单调性
				while(x<n && Math.max(dp[k-1][x-1], dp[k][n-x]) > Math.max(dp[k-1][x], dp[k][n-x-1])) {
					x++;
				}
				dp[k][n] = Math.max(dp[k-1][x-1], dp[k-1][n-x])+1;
			}
		}
		
		return dp[K][N];
	}

	
	public static void main(String[] args) {
		
		// 2
//		int K = 1;
//		int N = 2;
		
		// 3
//		int K = 2;
//		int N = 6;
		
		// 4
		int K = 3;
		int N = 14;
		
		System.out.println(new Solution().superEggDrop(K, N));
	}
}
