package com.jasper.algs.leetcode.dp.qu0410.solu1;

import java.util.Arrays;

/**
 * 0410. 分割数组的最大值
 * 
 * <p> 动态规划
 */
class Solution {
    public int splitArray(int[] nums, int m) {
         int n = nums.length;
         
         // 前缀和
         int[] sub = new int[n + 1];
         for (int i = 0; i < n; i++) {
        	 sub[i + 1] = sub[i] + nums[i];
         }
         // 动态规划
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}