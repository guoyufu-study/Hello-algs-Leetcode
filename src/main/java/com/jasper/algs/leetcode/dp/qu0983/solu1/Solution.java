package com.jasper.algs.leetcode.dp.qu0983.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 0983. 最低票价
 * 
 * <p>
 * 动态规划：日期变量型 - 自上而下（递归）
 *
 */
class Solution {
	int[] costs;
	Integer[] memo;
	Set<Integer> dayset;

	public int mincostTickets(int[] days, int[] costs) {
		this.costs = costs;
		memo = new Integer[366];
		dayset = new HashSet<>();
		for (int d : days) {
			dayset.add(d);
		}
		int ans = dp(1);
		return ans;
	}

	public int dp(int i) {
		if (i > 365) {
			return 0;
		}
		if (memo[i] != null) {
			return memo[i];
		}
		if (dayset.contains(i)) {
			memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
		} else {
			memo[i] = dp(i + 1);
		}
		return memo[i];
	}

	public static void main(String[] args) {
		int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
		int[] costs = new int[] { 2, 7, 15 };

		System.out.println(new Solution().mincostTickets(days, costs));
	}
}