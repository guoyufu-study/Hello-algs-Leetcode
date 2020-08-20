package com.jasper.algs.leetcode.dp.qu0518.solu1;

/**
 * 0518. 零钱兑换 II
 * 
 * <p> 动态规划
 */
class Solution {
    public int change(int amount, int[] coins) {
    	// 无硬币
    	int[] dp = new int[amount+1];
    	dp[0] = 1; // 目标金额为0
    	
    	// 逐个增加硬币种类
    	for (int j = 0; j < coins.length; j++) {
			for (int S = 1; S <= amount; S++) {
				if(S-coins[j]>=0)
					dp[S] += dp[S-coins[j]]; 
			}
		}
    	
    	return dp[amount];
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