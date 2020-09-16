package com.jasper.algs.leetcode.dp.qu0322.solu1;

import java.util.Arrays;

/**
 * 0322.零钱兑换
 * 
 * <p>  枚举硬币：二维 DP
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
    	int n = coins.length;
    	int[][] dp = new int[n+1][amount+1];
    	Arrays.fill(dp[0], Integer.MAX_VALUE);
    	dp[0][0] = 0;
    	for (int i = 0; i < n; i++) {// 枚举硬币
    		for (int s = 0; s <= amount; s++) {
    			dp[i+1][s] = dp[i][s]; // 不选
				if(s-coins[i]>=0 && dp[i+1][s-coins[i]]!=Integer.MAX_VALUE) { // 选
					dp[i+1][s] = Math.min(dp[i+1][s], dp[i+1][s-coins[i]]+1);
				}
			}
		}
    	
    	return dp[n][amount]==Integer.MAX_VALUE ? -1 : dp[n][amount];
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
