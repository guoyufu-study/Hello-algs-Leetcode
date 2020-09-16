package com.jasper.algs.leetcode.dp.qu0322.solu4;

/**
 * 0322.零钱兑换
 * 
 * <p> 动态规划：自下而上
 */
class Solution {
    public int coinChange(int[] coins, int amount) {

    	// 边界
    	if(coins==null || coins.length==0 || amount<0)
    		return -1;
    	
    	// 自下而上动态规划
    	int[] dp = new int[amount+1];
    	dp[0] = 0;
    	for (int S = 1; S <= amount; S++) {
    		int count = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if(S >= coins[j])
					count = Math.min(count, dp[S-coins[j]]);
			}
			dp[S] = count==Integer.MAX_VALUE ? Integer.MAX_VALUE : count + 1;
		}
    	
    	return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    	
    }
    
	public static void main(String[] args) {
		// 3
    	int[] coins = new int[] {1, 2, 5};
		int amount = 11;
		
		// -1
//		int[] coins = new int[] {2};
//		int amount = 1;
		
		// 注意边界
		// 0
//    	int[] coins = new int[] {1};
//		int amount = 0;
    	
		// 20
//    	int[] coins = new int[] {186,419,83,408};
//    	int amount = 6249;

		
		System.out.println(new Solution().coinChange(coins, amount));
	}
}
