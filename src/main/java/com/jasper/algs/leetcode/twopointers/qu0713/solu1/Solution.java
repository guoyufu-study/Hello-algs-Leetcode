package com.jasper.algs.leetcode.twopointers.qu0713.solu1;

/**
 * 0713. 乘积小于K的子数组
 *
 * <p>滑动窗口
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    	// 边界 0、1
    	if(k<=1) return 0;
    	
    	int N = nums.length;
    	int ans = 0;
    	
    	// 滑动窗口
    	int left=0, right=0;
    	int prod = 1;
    	while(right<N) {
    		// 乘 nums[right]
    		prod *= nums[right];
			// 除 nums[left]
			while(prod>=k) 
				prod/=nums[left++];
    		// 只统计以nums[right]结尾的子数组
    		ans += right-left+1;
			right++;
    	}
    	
    	return ans;
    }
}