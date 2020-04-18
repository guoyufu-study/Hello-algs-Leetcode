package com.jasper.algs.leetcode.twopointers.qu0042.solu2;

/**
 * 2. 两个辅助数组
 * 
 * <p> 优化暴力求解
 */
class Solution {

	public int trap(int[] heights) {
		// 边界值
		int n = heights.length;
		if(n<=2) return 0;
		
		// 左档板
		int[] maxLeft = new int[n];
		maxLeft[0] = heights[0];
		for (int i = 1; i < n; i++) {
			maxLeft[i] = maxLeft[i-1] < heights[i] ? heights[i] : maxLeft[i-1];
		}
		
		// 右档板
		int[] maxRight = new int[n];
		maxRight[n-1] = heights[n-1];
		for (int i = n-2; i >= 0; i--) {
			maxRight[i] = maxRight[i+1] < heights[i] ? heights[i] : maxRight[i+1];
		}
		
		// 结果
		int ans = 0;
		
		for (int i = 1; i < n-1; i++) { // 每个柱子（不包括最左柱子，最右柱子）
			// 接雨水
			ans += Math.min(maxLeft[i], maxRight[i]) - heights[i];
		}
		
		return ans;
    }
}
