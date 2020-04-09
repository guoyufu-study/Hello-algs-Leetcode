package com.jasper.algs.leetcode.array.qu0084.solu5;

class Solution {
    public int largestRectangleArea(int[] heights) {
    	if(heights.length==0) return 0;
    	
    	int ans = 0;
    	
    	for (int i = 0; i < heights.length; i++) {
			int height = heights[i];//定位矩形高度
			// 定位最左边界
			int left = i;
			while (left>0 && heights[left] >= heights[i]) left--;
			if(heights[left] < heights[i]) left++;
			// 定位最右边界
			int right = i;
			while(right<heights.length-1 && heights[right] >= heights[i]) right++;
			if(heights[right] < heights[i]) right--;
			
			// 尽可能大的矩形面积
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