package com.jasper.algs.sword2offer.qu003.solu3;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 
 * <p> 辅助字典
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        
    	int n = nums.length;

        boolean[] tmp = new boolean[n];
        for(int i=0; i<n; i++) {
            if(tmp[nums[i]])
                return nums[i];
            tmp[nums[i]] = true;
        }
        
        return -1;
    }
}