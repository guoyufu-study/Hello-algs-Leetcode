package com.jasper.algs.contest.weekly.c097.qu0887.solu2;

/**
 * 0887. 鸡蛋掉落
 * 
 * <p> 动态规划 + 二分查找
 */
class Solution {
	public int superEggDrop(int K, int N) {
		// 边界
		if(K==1 || N==1) return N;
		
		int[][] dp = new int[K+1][N+1]; // 0个鸡蛋 or 0层楼
		for(int i=1; i<=K; i++) dp[i][1] = 1; // i个鸡蛋 1 层楼
		for(int j=1; j<=N; j++) dp[1][j] = j; // 1个鸡蛋 j层楼
		
		for (int i = 2; i <= K; i++) {
			for (int j = 2; j <= N; j++) {
				int low = 1, high = j;
				while(low+1<high) {
					int x = (low+high)/2;
					int t1 = dp[i-1][x-1];
					int t2 = dp[i][j-x];
					
					if(t1<t2) low = x;
					else if(t1>t2) high = x;
					else low = high = x;
				}
				dp[i][j] = 1+Math.min(Math.max(dp[i-1][low-1], dp[i][j-low]), 
						Math.max(dp[i-1][high-1], dp[i][j-high]));
//				dp[i][j] = dp[i][j-1]; // 先从1楼扔鸡蛋
//				for(int x=2; x<=j; x++) // 先从x楼扔鸡蛋
//					dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][x-1], dp[i][j-x]));
//				dp[i][j]++;
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
