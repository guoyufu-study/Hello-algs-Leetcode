package com.jasper.algs.contest.weekly.c204.qu1567.solu2;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 
 * <p> 动态规划
 */
class Solution {
    public int getMaxLen(int[] nums) {
    	int n = nums.length, ans = 0;
    	int[] pos = new int[n+1];
    	int[] neg = new int[n+1];
    	for (int i = 0; i < n; i++) {
    		pos[i+1] = nums[i] > 0 ? pos[i]+1 : nums[i] == 0 || neg[i] == 0 ? 0 : neg[i]+1;
			neg[i+1] = nums[i] < 0 ? pos[i]+1 : nums[i] == 0 || neg[i] == 0 ? 0 : neg[i]+1;
			ans = Math.max(ans, pos[i+1]);
		}
    	
    	return ans;
    }
}