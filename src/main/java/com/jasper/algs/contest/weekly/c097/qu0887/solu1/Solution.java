package com.jasper.algs.contest.weekly.c097.qu0887.solu1;

/**
 * 0887. 鸡蛋掉落
 * 
 * <p> 动态规划（超时）
 */
class Solution {
	public int superEggDrop(int K, int N) {
		
		int[][] dp = new int[K+1][N+1]; // 0个鸡蛋 or 0层楼
		for(int n=1; n<=N; n++) dp[1][n] = n; // 1个鸡蛋 n层楼
		
		for (int k = 2; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				dp[k][n] = dp[k][n-1]; // 先从1楼扔鸡蛋
				for(int x=2; x<=n; x++) // 先从x楼扔鸡蛋
					dp[k][n] = Math.min(dp[k][n], Math.max(dp[k-1][x-1], dp[k][n-x]));
				dp[k][n]++;
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
