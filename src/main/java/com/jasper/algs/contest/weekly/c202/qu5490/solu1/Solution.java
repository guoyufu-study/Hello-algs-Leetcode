package com.jasper.algs.contest.weekly.c202.qu5490.solu1;

/**
 * 5490. 吃掉 N 个橘子的最少天数
 * 
 * <p> 动态规划：超内存
 */
class Solution {
	
    public int minDays(int n) {
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	for(int i=2; i<=n; i++) {
    		dp[i] = dp[i-1] + 1;
    		if(i%2==0) {
    			dp[i] = Math.min(dp[i/2]+1, dp[i]);
    		}
    		if(i%3==0) {
    			dp[i] = Math.min(dp[i], dp[i-2*(i/3)]+1);
    		}
    	}
    	
    	return dp[n];
    }
    
    public static void main(String[] args) {
		int n = 61455274;
		
		System.out.println(new Solution().minDays(n));
	}
}