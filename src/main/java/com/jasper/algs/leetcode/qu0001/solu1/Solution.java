package com.jasper.algs.leetcode.qu0001.solu1;

/**
 * 暴力求解：双层循环
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		for (int i = 0; i < length-1; i++) {//假设i
			for (int j = i+1; j < length; j++) {//找出j
                if (nums[i]+nums[j] == target) //条件判断
                    return new int[] {i, j};
            }
        }
		throw new IllegalArgumentException("No two sum solution");
	}
}
