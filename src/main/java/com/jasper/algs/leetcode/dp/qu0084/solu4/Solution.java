package com.jasper.algs.leetcode.dp.qu0084.solu4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0084. 柱状图中最大的矩形
 * 
 * <p>枚举高度：单调栈求宽度
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	if(heights==null || heights.length==0) return 0;
    	
    	int n = heights.length, ans = 0;
    	Deque<Integer> helper = new LinkedList<>();//单调非递减栈，用来缓存未计算矩形的高度，并定位左边界
    	helper.push(-1);// 哨兵
    	for (int i = 0; i < n; i++) {//枚举高度
			// height[i] 更小，i-1 就是右边界, helper[top-1]+1就是左边界，闭区间
			while(helper.peek()!=-1 && heights[i] <= heights[helper.peek()]) {
				int height = heights[helper.pop()];//高
				int width = (i-1) - helper.peek() ;//宽
				ans = Math.max(ans, height*width);//面积=高*宽
			}
			
			// height[i] 更大，无法定位 helper.peek()的右边界
			helper.push(i);
		}
    	
    	// heights.length-1 是右边界, helper[top-1]+1 是左边界，闭区间
    	while(helper.peek()!=-1) {
    		int height = heights[helper.pop()];
    		int width = (n-1) - helper.peek();
    		ans = Math.max(ans, height*width);
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 10
//		int[] heights = new int[] {2,1,5,6,2,3};
    	
    	// 4 必须处理相等的情况
		int[] heights = new int[] {1,3,1,3};
		
		int area = new Solution().largestRectangleArea(heights);
		System.out.println(area);
	}
}