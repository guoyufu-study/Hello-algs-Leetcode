package com.jasper.algs.leetcode.greedy.qu0871.solu1;

/**
 * 0871. 最低加油次数
 * 
 * <p>
 * 动态规划
 */
class Solution {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {

		int N = stations.length;

		// 第 index 次加油，能到达的最远位置
		int[] dp = new int[N + 1];
		dp[0] = startFuel;
		for (int i = 0; i < N; i++) {
			for (int t = i; t >= 0; t--) {
				if (dp[t] >= stations[i][0])
					dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
			}
		}

		for (int i = 0; i <= N; ++i)
			if (dp[i] >= target)
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
    	// 0
//		int target = 1;
//		int startFuel = 1;
//		int[][] stations = new int[][] {};
		
		// -1
//		int target = 100;
//		int startFuel = 1;
//		int[][] stations = new int[][] {{10,100}};
		
		// 2
		int target = 100;
		int startFuel = 10;
		int[][] stations = new int[][] {{10,60},{20,30},{30,30},{60,40}};
		
		System.out.println(new Solution().minRefuelStops(target, startFuel, stations));
	}
}