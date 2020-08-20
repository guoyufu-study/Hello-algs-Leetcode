package com.jasper.algs.leetcode.dp.qu0416.solu2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 0416. 分割等和子集
 * 
 * <p> 0/1背包：一维
 */
class Solution {
    public boolean canPartition(int[] nums) {

    	int sum = IntStream.of(nums).sum();
    	// 位操作判断奇偶
    	if((sum & 1) == 1) return false;
    	
    	// 转换成01背包问题
    	sum >>= 1;
    	boolean[] dp = new boolean[sum+1];
    	// 什么都不选
        Arrays.fill(dp, false);
        dp[0] = true;
    	
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] // 不选
                		|| dp[i-num]; // 选
            }
        }
        return dp[sum];
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