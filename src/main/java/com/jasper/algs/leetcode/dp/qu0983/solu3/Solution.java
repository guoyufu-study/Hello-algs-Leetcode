package com.jasper.algs.leetcode.dp.qu0983.solu3;

/**
 * 0983. 最低票价
 * 
 * <p>
 * 动态规划：窗口变量型 - 自上而下（递归）
 *
 */
class Solution {
	int[] days, costs;
	Integer[] memo;
	int[] durations = new int[] { 1, 7, 30 };

	public int mincostTickets(int[] days, int[] costs) {
		this.days = days;
		this.costs = costs;
		memo = new Integer[days.length];
		return dp(0);
	}

	public int dp(int i) {
		if (i >= days.length) {
			return 0;
		}
		if (memo[i] != null) {
			return memo[i];
		}
		memo[i] = Integer.MAX_VALUE;
		int j = i;
		for (int k = 0; k < 3; ++k) {
			while (j < days.length && days[j] < days[i] + durations[k]) {
				j++;
			}
			memo[i] = Math.min(memo[i], dp(j) + costs[k]);
		}
		return memo[i];
	}

	public static void main(String[] args) {
		int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
		int[] costs = new int[] { 2, 7, 15 };

		System.out.println(new Solution().mincostTickets(days, costs));
	}
}