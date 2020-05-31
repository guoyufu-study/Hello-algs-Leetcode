package com.jasper.algs.leetcode.dynamicprogramming.qu0983.solu2;

/**
 * 0983. 最低票价
 * 
 * <p>
 * 动态规划：日期变量型 - 自下而上（迭代）
 */
class Solution {

	public int mincostTickets(int[] days, int[] costs) {

		int[] dp = new int[366];
		int j = days.length - 1;
		for (int i = 365; i >= 1; i--) {
			// 剪枝
			if (j < 0)
				break;
			
			// 跳过
			if (i > days[j]) {
				dp[i] = i + 1 > 365 ? 0 : dp[i + 1];
				continue;
			}

			// i == days[j]
			int day = i + 1;
			int dp1 = (day > 365 ? 0 : dp[day]) + costs[0];
			day = i + 7;
			int dp7 = (day > 365 ? 0 : dp[day]) + costs[1];
			day = i + 30;
			int dp30 = (day > 365 ? 0 : dp[day]) + costs[2];
			
			dp[i] = Math.min(Math.min(dp1, dp7), dp30);
			
			j--;
		}

		return dp[days[0]];
	}

	public static void main(String[] args) {
		// 11
		int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
		int[] costs = new int[] { 2, 7, 15 };
		
		// 17
//		int[] days = new int[] { 1,2,3,4,5,6,7,8,9,10,30,31 };
//		int[] costs = new int[] { 2, 7, 15 };

		System.out.println(new Solution().mincostTickets(days, costs));
	}
}