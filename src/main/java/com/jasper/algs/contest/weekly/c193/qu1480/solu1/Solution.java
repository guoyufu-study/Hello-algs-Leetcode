package com.jasper.algs.contest.weekly.c193.qu1480.solu1;

/**
 * 1480. 一维数组的动态和
 * 
 * <p> 动态规划
 */
class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }

        return nums;
    }
}