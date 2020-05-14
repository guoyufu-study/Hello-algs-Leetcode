package com.jasper.algs.leetcode.dynamicprogramming.qu0053.solu3;

/**
 * 0053. 最大子序和
 * 
 * <p> 3. 贪心算法
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
        	return 0;
        
    	int ans = nums[0];
    	int sum = 0;
        for (int num : nums) {
			sum += num;
			ans = Math.max(ans, sum);
			if(sum<0) sum = 0;
		}
        
        return ans;
    }
}