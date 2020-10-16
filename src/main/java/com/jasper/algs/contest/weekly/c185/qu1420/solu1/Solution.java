package com.jasper.algs.contest.weekly.c185.qu1420.solu1;

/**
 * 1420. 生成数组
 *
 * <p> 三维动态规划
 */
class Solution {
    public int numOfArrays(int n, int m, int k) {

    	// 动态规划
    	long[][][] dp = new long[n+1][m+1][k+1];
    	for (int j = 1; j <= m; j++) {
			dp[1][j][1] = 1;
		}
    	for (int i = 1; i <= n; i++) {
    		for (int p = 1; p <= k; p++) {
    			if(i==1 && p==1) continue;
    			long sum = 0;
    			for (int j = 1; j <= m; j++) {
    				dp[i][j][p]
							= (sum + j*dp[i-1][j][p]) % 1_000_000_007;
    				sum = (sum + dp[i-1][j][p-1])%1_000_000_007;
				}
			}
		}
    	
    	// 构造答案
    	long ans = 0;
    	for (int j = 1; j <= m; j++) {
			ans += dp[n][j][k];
		}
    	return (int)(ans%1_000_000_007);
    }
    
    public static void main(String[] args) {
    	// 6
//		int n = 2;
//		int m = 3;
//		int k = 1;
		
		// 0
//		int n = 5;
//		int m = 2;
//		int k = 3;
		
		// 1
//		int n = 9;
//		int m = 1;
//		int k = 1;
		
		// 34549172
//		int n = 50;
//		int m = 100;
//		int k = 25;
		
		// 418930126
		int n = 37;
		int m = 17;
		int k = 7;
		
		System.out.println(new Solution().numOfArrays(n, m, k));
	}
}