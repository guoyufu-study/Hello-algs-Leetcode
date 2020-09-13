package com.jasper.algs.leetcode.twopointers.qu0485.solu1;

/**
 * 0485. 最大连续1的个数
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    	int n = nums.length, left = 0, right = 0, ans = 0;
    	while(right < n) {
    		if(nums[right]==0) {
    			ans = Math.max(ans, right-left);
    			left = right+1;
    		}
    		right++;
    	}
    	return Math.max(ans, right-left);
    }
}