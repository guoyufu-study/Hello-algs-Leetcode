package com.jasper.algs.leetcode.twopointers.qu0011.solu1;

/**
 * 暴力求解：尝试所有可能组合
 */
class Solution {

	public int maxArea(int[] height) {
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {// 尝试所有可能组合
				ans = Math.max(ans, (j-i)*Math.min(height[i], height[j]));
			}
		}
		return ans;
	}
}
