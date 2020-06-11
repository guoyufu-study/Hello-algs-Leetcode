package com.jasper.algs.contest.weekly.c192.qu1470.solu2;

/**
 * 1470. 重新排列数组
 * 
 * <p>
 * 原地排序
 */
class Solution {
	public int[] shuffle(int[] nums, int n) {

		// 0~9位存原数、10~19位存排序后的数
		for (int i = 0; i < 2 * n; i++) {
			// 应排位置
			int j = i < n ? 2 * i : 2 * (i - n) + 1;
			// 先消去排序后的数
			nums[j] |= (nums[i] & 1023) << 10;
		}

		// 消去原数
		for (int i = 0; i < 2 * n; i++)
			nums[i] >>= 10;

		return nums;
	}
}
