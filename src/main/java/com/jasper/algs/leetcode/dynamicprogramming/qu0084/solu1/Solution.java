package com.jasper.algs.leetcode.dynamicprogramming.qu0084.solu1;

/**
 * 0084. 柱状图中最大的矩形
 *
 *	<p>暴力求解1
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	int N = heights.length;
		if(N==0) return 0;
    	
    	int ans = 0;
    	
    	for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {// 尝试计算每一个可能的矩形
				int minheight = Integer.MAX_VALUE;	//求最小高度
				for (int k = i; k <= j; k++)
					minheight = Math.min(minheight, heights[k]);
				
				ans = Math.max(ans, minheight*(j-i+1));//求最大面积
			}
		}
    	
    	return ans;
    }
}