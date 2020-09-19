package com.jasper.algs.contest.weekly.c097.qu0887.solu2;

/**
 * 0887. 鸡蛋掉落
 * 
 * <p> 动态规划 + 二分查找
 */
class Solution {
	public int superEggDrop(int K, int N) {
		// 动态规划
		int[][] dp = new int[K+1][N+1]; // 0个鸡蛋 or 0层楼
		for(int n=1; n<=N; n++) dp[1][n] = n; // 1个鸡蛋 n层楼
		for (int k = 2; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				// 二分查找
				int low = 1, high = n;
				while(low+1<high) { // 离散值相差 1
					int x = (low+high)/2;
					int t1 = dp[k-1][x-1];
					int t2 = dp[k][n-x];
					
					if(t1<t2) low = x;
					else if(t1>t2) high = x;
					else low = high = x;
				}
				dp[k][n] = 1 + Math.min(
						Math.max(dp[k-1][low-1], dp[k][n-low]), 
						Math.max(dp[k-1][high-1], dp[k][n-high]));
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
