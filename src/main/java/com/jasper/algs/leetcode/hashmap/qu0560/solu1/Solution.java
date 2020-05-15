package com.jasper.algs.leetcode.hashmap.qu0560.solu1;

/**
 * 0560. 和为K的子数组
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
    	
    	int ans = 0;
    	
    	// 构造子数组[start, end]
    	for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum += nums[end]; // 求和
				if(sum==k) ans++; // 计数
			}
		}
    	
    	return ans;
    }
}