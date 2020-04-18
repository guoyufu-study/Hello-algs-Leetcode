package com.jasper.algs.leetcode.twopointers.qu0042.solu1;

/**
 * 暴力破解
 * 
 * <p>逐一计算每个柱子能接雨水的量。
 * <p> 针对每个柱子，找出其左右档板
 */
class Solution {

	public int trap(int[] heights) {
		// 边界值
		int n = heights.length;
		if(n<=2) return 0;
		
		// 结果
		int ans = 0;
		
		for (int i = 1; i < n-1; i++) { // 每个柱子（不包括最左柱子，最右柱子）
			int maxLeft = heights[0];
			// 左档板
			for (int j = 1; j <= i; j++) {
				if(maxLeft<heights[j])
					maxLeft = heights[j];
			}
			
			// 右档板
			int maxRight = heights[i];
			for (int j = i+1; j < n; j++) {
				if(maxRight<heights[j])
					maxRight = heights[j];
			}
			
			// 接雨水
			ans += Math.min(maxLeft, maxRight) - heights[i];
		}
		
		return ans;
    }
}
