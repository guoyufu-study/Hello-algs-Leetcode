package com.jasper.algs.leetcode.hashmap.qu0001.solu1;

/**
 * 0001.两数之和
 * 
 * <p>暴力枚举：尝试每一种组合
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		for (int i = 0; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
                if (nums[i]+nums[j] == target) // 判断是否满足条件
                    return new int[] {i, j};
            }
        }
		throw new IllegalArgumentException("No two sum solution");
	}
}
