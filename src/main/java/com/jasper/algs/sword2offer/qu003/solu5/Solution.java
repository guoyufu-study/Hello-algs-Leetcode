package com.jasper.algs.sword2offer.qu003.solu5;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 
 * <p>
 * 原地置换
 */
class Solution {
	public int findRepeatNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			// 原地转换
			while (nums[i] != i) {
				if (nums[nums[i]] == nums[i]) {
					return nums[i];
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}

		throw new IllegalArgumentException("没有解");
	}
}