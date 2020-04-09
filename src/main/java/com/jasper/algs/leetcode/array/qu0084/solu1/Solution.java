package com.jasper.algs.leetcode.array.qu0084.solu1;

/**
 * 暴力求解
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	if(heights.length==0) return 0;
    	
    	int ans = 0;
    	
    	for (int i = 0; i < heights.length; i++) {
			for (int j = i; j < heights.length; j++) {
				int minheight = Integer.MAX_VALUE;	//求最小高度
				for (int k = i; k <= j; k++)
					minheight = Math.min(minheight, heights[k]);
				
				ans = Math.max(ans, minheight*(j-i+1));//求最大面积
			}
		}
    	
    	return ans;
    }
}