package com.jasper.algs.leetcode.dp.qu0639.solu1;

/**
 * 0639. 解码方法 2
 * 
 * <p> 动态规划
 */
class Solution {
	static final int mod = 1_000_000_007;
    public int numDecodings(String s) {
    	int n = s.length();
    	char[] sc = s.toCharArray();
    	long[] dp = new long[n+1];
    	dp[0] = 1;
    	dp[1] = sc[0]=='0' ? 0 : sc[0]!='*' ? 1 : 9; // 首字符
    	for (int i = 2; i <= n; i++) {
			if(sc[i-1]=='*') { // *
				dp[i] = 9 * dp[i-1]; // 单组
				if(sc[i-2]=='1' || sc[i-2]=='*') dp[i] += 9 * dp[i-2]; // 组合 1
				if(sc[i-2]=='2' || sc[i-2]=='*') dp[i] += 6 * dp[i-2]; // 组合 2
			} else { // 0, 1-9
				dp[i] = sc[i-1]=='0' ? 0 : dp[i-1]; // 单组
				if(sc[i-2]=='1' || sc[i-2]=='*') dp[i] += dp[i-2];// 组合 1
				if((sc[i-2]=='2' || sc[i-2]=='*') && sc[i-1] < '7') dp[i] += dp[i-2];// 组合 2
			}
			
			dp[n] %= mod;
		}
    	return (int)dp[n];
    }
}