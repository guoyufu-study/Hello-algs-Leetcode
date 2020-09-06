package com.jasper.algs.leetcode.array.qu0189.solu3;

/**
 * 0189. 旋转数组
 * 
 * <p> 环状替换
 */
class Solution {
    public void rotate(int[] nums, int k) {
    	int n = nums.length, step = 0;
    	int prev = nums[0], index = 0, start = 0;
    	while(step < n) {
    		index = (index + k) % n;
    		int tmp = nums[index];
    		nums[index] = prev;
    		prev = tmp;
    		if(index == start) {
    			index = (index+1)%n;
    			start = index;
    			prev = nums[start];
    		}
    		
    		step++;
    	}
    }
}