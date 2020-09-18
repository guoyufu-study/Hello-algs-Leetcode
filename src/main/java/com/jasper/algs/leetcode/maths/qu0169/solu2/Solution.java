package com.jasper.algs.leetcode.maths.qu0169.solu2;

import java.util.Arrays;

/**
 * 0169.求众数I
 * 
 * <p> 排序 -> 中间数
 */
class Solution {
    public int majorityElement(int[] nums) {
    	//排序
    	Arrays.sort(nums);
    	// 中间数
        return nums[nums.length >> 1];
    }
}