package com.jasper.algs.leetcode.dp.qu0377.solu2;

/**
 * 0377.组合总和 Ⅳ
 * 
 * <p> 动态规划 - 完全背包问题
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
    	int[] dp = new int[target+1];
    	dp[0] = 1;
    	
    	for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				if(num<=i)
					dp[i] += dp[i-num];
			}
		}
    	
    	return dp[target];
    }
}