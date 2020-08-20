package com.jasper.algs.leetcode.dp.qu0084.solu6;

/**
 * 0084. 柱状图中最大的矩形
 * 
 * <p>分治算法
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	int N = heights.length;
		if(N==0) return 0;
    	
		// 最大矩形面积
    	return calculateArea(heights, 0, N-1);
    }
    
    /**
     * 求最大矩形面积
     * 
     * @param heights 原高度数组
     * @param start 左侧柱子，闭区间
     * @param end 右侧柱子，闭区间
     * @return
     */
    public int calculateArea(int[] heights, int start, int end) {
    	// 终止
    	if(start>end) return 0;
    	
    	int minindex = start;	// 定位最小高度
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;

        return Math.max(heights[minindex] * (end - start + 1), // 最小高度矩形
        		Math.max(calculateArea(heights, start, minindex - 1),//左侧矩形
        				calculateArea(heights, minindex + 1, end)));//右侧矩形

    }
    
    public static void main(String[] args) {
		int[] heights = new int[] {2,1,5,6,2,3};
		
		new Solution().largestRectangleArea(heights);
	}
}