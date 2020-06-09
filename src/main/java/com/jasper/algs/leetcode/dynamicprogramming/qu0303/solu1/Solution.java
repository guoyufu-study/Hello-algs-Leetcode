package com.jasper.algs.leetcode.dynamicprogramming.qu0303.solu1;

/**
 * 0303. 区域和检索 - 数组不可变
 * 
 * <p> 前缀和
 */
class NumArray {

	private int[] dp;
	
    public NumArray(int[] nums) {
    	dp = new int[nums.length+1];
    	for (int i = 0; i < nums.length; i++) {
			dp[i+1] = dp[i] + nums[i];
		}
    }
    
    public int sumRange(int i, int j) {
    	
    	return dp[j+1]-dp[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */