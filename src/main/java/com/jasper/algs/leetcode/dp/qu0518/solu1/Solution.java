package com.jasper.algs.leetcode.dp.qu0518.solu1;

/**
 * 0518. 零钱兑换 II
 * 
 * <p> 动态规划
 */
class Solution {
    public int change(int amount, int[] coins) {
    	int n = coins.length;
    	// 前 0 种硬币
    	int[][] dp = new int[n+1][amount+1];
    	dp[0][0] = 1; // 前 0 种硬币凑成总金额 0 的硬币组合数 1
    	
    	// 逐个增加硬币种类
    	for (int i = 0; i < coins.length; i++) {
			for (int S = 0; S <= amount; S++) {
				dp[i+1][S] = dp[i][S];
				if(S-coins[i]>=0)
					dp[i+1][S] += dp[i+1][S-coins[i]]; 
			}
		}
    	
    	return dp[n][amount];
    }
    
    public static void main(String[] args) {
    	
    	// 4
//		int amount = 5;
//		int[] coins = new int[] {1, 2, 5};
		
		// 0
//		int amount = 3;
//		int[] coins = new int[] {2};
		
		// 1
		int amount = 10;
		int[] coins = new int[] {10};
		
		System.out.println(new Solution().change(amount, coins));
	}
}