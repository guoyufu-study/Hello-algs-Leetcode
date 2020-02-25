package com.jasper.algs.leetcode.qu0001.solu1;

/**
 * 暴力求解：双层循环
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j] == target) 
					return new int[] {i , j};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
