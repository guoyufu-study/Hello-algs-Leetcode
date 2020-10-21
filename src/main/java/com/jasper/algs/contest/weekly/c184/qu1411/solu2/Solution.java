package com.jasper.algs.contest.weekly.c184.qu1411.solu2;

/**
 * 1411. 给 N x 3 网格图涂色的方案数
 * 
 * <p> 动态规划
 */
class Solution {
    public int numOfWays(int n) {
    	int mod = 1_000_000_007;
    	long f = 3, g = 0;
    	for(int i=1; i<=n; i++) {
    		f = ((f + g)<<1)%mod;
    		g = (f + g)%mod;
    	}
    	return (int)((f+g)%mod);
    }
}