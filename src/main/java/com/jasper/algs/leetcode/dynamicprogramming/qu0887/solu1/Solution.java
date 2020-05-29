package com.jasper.algs.leetcode.dynamicprogramming.qu0887.solu1;

/**
 * 0887. 鸡蛋掉落
 * 
 * <p> 动态规划（超时）
 */
class Solution {
	public int superEggDrop(int K, int N) {
		// 边界
		if(K==1) return N;
		if(N==1) return N;
		
		// i个鸡蛋 j 层楼
		int[][] dp = new int[K+1][N+1];
		// 1个鸡蛋 j层楼
		for (int j = 1; j <= N; j++)
			dp[1][j] = j;
		// i个鸡蛋 1 层楼
		for (int i = 1; i <= K; i++)
			dp[i][1] = 1;
		
		for (int k = 2; k <= K; k++) {
			for (int n = 2; n <= N; n++) {
				dp[k][n] = Math.max(dp[k][n-1], dp[k-1][0]);
				for (int x = 2; x <= n; x++) {
					dp[k][n] = Math.min(dp[k][n], Math.max(dp[k][n-x], dp[k-1][x-1]));
				}
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
