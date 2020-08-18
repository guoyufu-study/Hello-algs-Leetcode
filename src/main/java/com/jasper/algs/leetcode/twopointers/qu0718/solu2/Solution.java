package com.jasper.algs.leetcode.twopointers.qu0718.solu2;

/**
 * 0718. 最长重复子数组
 * 
 * <p> 动态规划
 */
class Solution {

	public int findLength(int[] A, int[] B) {
		int n = A.length, m = B.length, ans = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                dp[i][j] = A[i]==B[j] ? dp[i+1][j+1]+1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
	}
}
