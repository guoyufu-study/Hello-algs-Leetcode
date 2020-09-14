package com.jasper.algs.leetcode.dp.qu0084.solu1;

/**
 * 0084. 柱状图中最大的矩形
 *
 *	<p>枚举宽度：暴力求高度
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	int n = heights.length;
		if(n==0) return 0;
    	
    	int ans = 0;
    	for (int i = 0; i < n; i++) {// 枚举起点
			for (int j = i; j < n; j++) {// 枚举终点
				int w = j-i+1;//求宽度
				int h = Integer.MAX_VALUE;	//求高度
				for (int k = i; k <= j; k++)
					h = Math.min(h, heights[k]);
				ans = Math.max(ans, h*w);//求最大面积
			}
		}
    	
    	return ans;
    }
}