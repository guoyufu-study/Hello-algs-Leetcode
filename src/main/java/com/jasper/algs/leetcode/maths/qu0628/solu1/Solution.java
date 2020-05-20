package com.jasper.algs.leetcode.maths.qu0628.solu1;

import java.util.Arrays;

/**
 * 0628. 三个数的最大乘积
 * 
 * <p> 排序，找出最大的三个数，最小的两个数
 */
class Solution {
    public int maximumProduct(int[] nums) {
    	Arrays.parallelSort(nums);
    	int n = nums.length;
    	return Math.max(nums[0] * nums[1] * nums[n-1], 
    				nums[n-1] * nums[n-2] * nums[n-3]);
    }
}