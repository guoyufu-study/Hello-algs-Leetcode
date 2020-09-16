package com.jasper.algs.leetcode.dp.qu0518.solu2;

/**
 * 0518. 零钱兑换 II
 * 
 * <p> 动态规划：状态压缩
 */
class Solution {
    public int change(int amount, int[] coins) {
    	// 前 0 种硬币
    	int[] dp = new int[amount+1];
    	dp[0] = 1; // 前 0 种硬币凑成总金额 0 的硬币组合数 1
    	
    	// 逐个增加硬币种类
    	for (int coin : coins) {
			for (int S = coin; S <= amount; S++) {
				dp[S] += dp[S-coin]; 
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