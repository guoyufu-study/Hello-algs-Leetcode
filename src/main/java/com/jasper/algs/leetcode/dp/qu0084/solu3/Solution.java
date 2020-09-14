package com.jasper.algs.leetcode.dp.qu0084.solu3;

/**
 * 0084. 柱状图中最大的矩形
 *
 *	<p>枚举高度：暴力求宽度
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	int N = heights.length;
		if(N==0) return 0;
    	
    	int ans = 0;
    	
    	for (int i = 0; i < N; i++) {
    		//定位矩形高度
			int height = heights[i];
			
			// 定位最左边界
			int left = i;
			while (left>0 && heights[left] >= heights[i]) left--;
			if(heights[left] < heights[i]) left++;
			
			// 定位最右边界
			int right = i;
			while(right<N-1 && heights[right] >= heights[i]) right++;
			if(heights[right] < heights[i]) right--;
			
			// 计算尽可能大的矩形面积
			ans = Math.max(height*(right-left+1), ans);
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] heights = new int[] {2,1,5,6,2,3};
		
		int area = new Solution().largestRectangleArea(heights);
		System.out.println(area);
	}
}