package com.jasper.algs.sword2offer.qu003.solu4;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 
 * <p> 原地标识
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        
    	for(int index : nums) {
            int tmp = Math.abs(index);
             if(nums[tmp]<0)
                return tmp;
             nums[tmp] *= -1;
        }

        return 0;
    }
}