package com.jasper.algs.leetcode.array.qu0084.solu3;

/**
 * 分治算法
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	if(heights.length==0) return 0;
    	
    	return calculateArea(heights, 0, heights.length-1);
    }
    
    public int calculateArea(int[] heights, int start, int end) {
    	if(start>end) return 0;
    	
    	int minindex = start;	// 定位最小高度
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;

        return Math.max(heights[minindex] * (end - start + 1), 
        		Math.max(calculateArea(heights, start, minindex - 1),
        				calculateArea(heights, minindex + 1, end)));

    }
    
    public static void main(String[] args) {
		int[] heights = new int[] {2,1,5,6,2,3};
		
		new Solution().largestRectangleArea(heights);
	}
}