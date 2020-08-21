package com.jasper.algs.contest.weekly.c165.qu1278.solu1;

class Solution {
    public int palindromePartition(String s, int k) {

    	int n = s.length();
    	int[][] dp = new int[n+1][k+1];
    	for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
    	dp[0][0] = 0;
    	for (int i = 1; i <= n; i++) {
    		dp[i][1] = cost(s, 0, i-1);
    		int m = Math.min(i, k);
    		for (int j = 2; j <= m; j++) {
				for (int i0 = j-1; i0 < i; i0++) {
					dp[i][j] = Math.min(dp[i][j], dp[i0][j-1] + cost(s, i0, i-1));
				}
			}
		}
    	
    	return dp[n][k];
    }

	private int cost(String s, int i, int j) {
		int ans = 0;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) ans++;
			i++;
			j--;
		}
		return ans;
	}
}