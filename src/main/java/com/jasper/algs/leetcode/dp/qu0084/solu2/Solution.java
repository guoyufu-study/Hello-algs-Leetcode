package com.jasper.algs.leetcode.dp.qu0084.solu2;

/**
 * 0084. 柱状图中最大的矩形
 *
 *	<p>枚举宽度：DP求高度
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	int n = heights.length;
		if(n==0) return 0;
    	
    	int ans = 0;
    	for (int i = 0; i < n; i++) {//枚举起点
    		//一维DP，dp[n] = min(dp[n-1], heights[n])
    		int h = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) { // 枚举终点
				h = Math.min(h, heights[j]); // 求高度
				ans = Math.max(ans, h*(j-i+1)); // 求最大面积
			}
		}
    	
    	return ans;
    }
}