package com.jasper.algs.leetcode.dynamicprogramming.qu0416.solu1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 0416. 分割等和子集
 * 
 * <p> 0/1背包：二维
 */
class Solution {
    public boolean canPartition(int[] nums) {

    	int sum = IntStream.of(nums).sum();
        if((sum & 1) == 1) return false;

        sum >>= 1;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;

        for(int i=1; i<=n; i++) {
            int m = Math.min(nums[i-1], sum+1);
            for(int j=0; j<m; j++) {
                dp[i][j] = dp[i-1][j];
            }

            for(int j=nums[i-1]; j<=sum; j++) {
                dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
        }

        return dp[n][sum];

    }
    
    public static void main(String[] args) {
		int[][] nums = new int[][] {
			{1, 5, 11, 5}, // true
			{1, 2, 3, 5}, // false
		};
		
		Arrays.stream(nums)
			.map(new Solution()::canPartition)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}