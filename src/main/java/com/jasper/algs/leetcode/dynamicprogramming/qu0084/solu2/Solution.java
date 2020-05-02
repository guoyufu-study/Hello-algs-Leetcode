package com.jasper.algs.leetcode.dynamicprogramming.qu0084.solu2;


/**
 * 0084. 柱状图中最大的矩形
 *
 *	<p>优化暴力求解：一维DP
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	int N = heights.length;
		if(N==0) return 0;
    	
    	int ans = 0;
    	
    	for (int i = 0; i < N; i++) {
    		//一维DP，maxHeight[n] = max(maxHeight[n-1], heights[n])
    		int minheight = Integer.MAX_VALUE;
			for (int j = i; j < N; j++) {
				minheight = Math.min(minheight, heights[j]); // 求最小高度
				ans = Math.max(ans, minheight*(j-i+1)); // 求最大面积
			}
		}
    	
    	return ans;
    }
}