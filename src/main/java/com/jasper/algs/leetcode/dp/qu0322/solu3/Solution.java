package com.jasper.algs.leetcode.dp.qu0322.solu3;

/**
 * 0322.零钱兑换
 * 
 * <p>
 * 动态规划：自上而下
 */
class Solution {

	private int[] coins;
	private int[] dp;

	public int coinChange(int[] coins, int amount) {

		// 边界
		if (coins == null || coins.length == 0 || amount < 0)
			return -1;

		this.coins = coins;
		dp = new int[amount + 1];

		// 自上而下动态规划
		return coinChange(amount);

	}

	private int coinChange(int rem) {
		// 边界
		if (rem < 0)
			return -1;
		if (rem == 0)
			return 0;

		// 使用缓存
		if (dp[rem] != 0)
			return dp[rem];

		// 计算
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(rem - coin);
			if (res >= 0 && res < min)
				min = 1 + res;
		}

		// 缓存
		dp[rem] = (min == Integer.MAX_VALUE) ? -1 : min;

		return dp[rem];

	}

	public static void main(String[] args) {
		// 3
//    	int[] coins = new int[] {1, 2, 5};
//		int amount = 11;

		// -1
//		int[] coins = new int[] {2};
//		int amount = 3;

		// 注意边界
		// 0
//    	int[] coins = new int[] {1};
//		int amount = 0;

		// 20
		int[] coins = new int[] { 186, 419, 83, 408 };
		int amount = 6249;

		System.out.println(new Solution().coinChange(coins, amount));
	}
}
