package com.jasper.algs.leetcode.dp.qu0322.solu2;

import java.util.Arrays;

/**
 * 0322.零钱兑换
 * 
 * <p>  枚举硬币：状态压缩
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
    	int n = coins.length;
    	int[] dp = new int[amount+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for (int i = 0; i < n; i++) {
			for (int s = coins[i]; s <= amount; s++) {
				if(dp[s-coins[i]]!=Integer.MAX_VALUE)
					dp[s] = Math.min(dp[s], dp[s-coins[i]] + 1);
			}
		}
    	return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
		// 3
//    	int[] coins = new int[] {1, 2, 5};
//		int amount = 11;
		
		// -1
		int[] coins = new int[] {2};
		int amount = 3;
		
		System.out.println(new Solution().coinChange(coins, amount));
	}
}
