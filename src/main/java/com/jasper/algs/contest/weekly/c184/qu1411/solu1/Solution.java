package com.jasper.algs.contest.weekly.c184.qu1411.solu1;

/**
 * 1411. 给 N x 3 网格图涂色的方案数
 * 
 * <p> 动态规划
 */
class Solution {
    public int numOfWays(int n) {
    	int mod = 1_000_000_007;
    	long[] f = new long[n+1];
    	f[0] = 3;
    	long[] g = new long[n+1];
    	for(int i=1; i<=n; i++) {
    		f[i] = ((f[i] + g[i])<<1)%mod;
    		g[i] = (f[i] + g[i-1])%mod;
    	}
    	return (int)((f[n]+g[n])%mod);
    }
}