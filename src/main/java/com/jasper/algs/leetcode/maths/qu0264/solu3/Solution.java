package com.jasper.algs.leetcode.maths.qu0264.solu3;

/**
 * 0264. 丑数 II
 * 
 * <p> 动态规划
 */
class Solution {
    public int nthUglyNumber(int n) {
    	// 三指针
    	int p2=0, p3=0, p5=0;
    	// 辅助数组
    	int[] dp = new int[n];
    	dp[0] = 1;
    	for (int i = 1; i < n; i++) {
    		// 动态规划
			dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
			if(dp[i]==dp[p2]*2) p2++;
			if(dp[i]==dp[p3]*3) p3++;
			if(dp[i]==dp[p5]*5) p5++;
		}
    	
    	return dp[n-1];
    }
    
    public static void main(String[] args) {
    	// 12
		int n = 10;
		
		System.out.println(new Solution().nthUglyNumber(n));
	}
}