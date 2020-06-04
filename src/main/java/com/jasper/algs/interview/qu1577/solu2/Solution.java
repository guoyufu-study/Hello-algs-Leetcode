package com.jasper.algs.interview.qu1577.solu2;

/**
 * 1577. 面试题 17.09. 第 k 个数
 * 
 * <p>
 * 三指针
 */
class Solution {
	public int getKthMagicNumber(int k) {

		int p3 = 0, p5 = 0, p7 = 0;
		int[] dp = new int[k];
		dp[0] = 1;
		for (int i = 1; i < k; i++) {
			dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
			if (dp[i] == dp[p3] * 3)
				p3++;
			if (dp[i] == dp[p5] * 5)
				p5++;
			if (dp[i] == dp[p7] * 7)
				p7++;
		}
		return dp[k - 1];

	}

	public static void main(String[] args) {
		// 9
//    	int k = 5;

		// 45
//    	int k = 11;

		// 1937102445
		int k = 643;
		System.out.println(new Solution().getKthMagicNumber(k));
	}
}