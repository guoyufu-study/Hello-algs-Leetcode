package com.jasper.algs.leetcode.dynamicprogramming.qu0983.solu4;

/**
 * 0983. 最低票价
 * 
 * <p>
 * 动态规划：窗口变量型 - 自下而上（迭代）
 *
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
    	
    	int[] durations = new int[]{1, 7, 30};
    	
        int N = days.length;
		int[] dp = new int[N];
        for (int i = N-1; i >= 0; i--) {
        	dp[i] = Integer.MAX_VALUE;
        	int j = i;
            for (int k = 0; k < 3; ++k) {
            	// 找到第一个 需要买票的日期 的索引
                while (j < N && days[j] < days[i] + durations[k]) {
                    j++;
                }
                dp[i] = Math.min(dp[i], 
                		(j>=N ? 0 : dp[j]) + costs[k]);
            }
		}
        
        return dp[0];
    }

//    private int dp(int i) {
//        if (i >= days.length) {
//            return 0;
//        }
//        if (memo[i] != null) {
//            return memo[i];
//        }
//        memo[i] = Integer.MAX_VALUE;
//        int j = i;
//        for (int k = 0; k < 3; ++k) {
//            while (j < days.length && days[j] < days[i] + durations[k]) {
//                j++;
//            }
//            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
//        }
//        return memo[i];
//    }


	public static void main(String[] args) {
		int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
		int[] costs = new int[] { 2, 7, 15 };

		System.out.println(new Solution().mincostTickets(days, costs));
	}
}