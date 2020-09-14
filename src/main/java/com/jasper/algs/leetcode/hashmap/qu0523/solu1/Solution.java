package com.jasper.algs.leetcode.hashmap.qu0523.solu1;

/**
 * 0523. 连续的子数组和
 * 
 * <p> 暴力枚举：暴力求和
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    	int n = nums.length;
    	for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int sum = 0;
				for (int x = i; x <= j; x++) {
					sum += nums[x];
				}
				if(sum==0 || (k!=0 && sum%k==0))
					return true;
			}
		}
    	return false;
    }
}