package com.jasper.algs.leetcode.dp.qu0053.solu2;

/**
 * 0053. 最大子序和
 * 
 * <p> 1. 动态规划
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
        	return 0;
        
    	int ans = nums[0], pre = 0;
        for (int num : nums) {
			pre = pre>0 ? pre+num : num;
			ans = Math.max(ans, pre);
		}
        
        return ans;
    }
}