package com.jasper.algs.leetcode.dp.qu0084.solu5;

import java.util.Stack;

/**
 * 0084. 柱状图中最大的矩形
 * 
 * <p>暴力求解2：一个单调栈
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
    	// 边界
    	if(heights==null || heights.length==0) return 0;
    	
    	int N = heights.length;
    	
    	int ans = 0;
    	Stack<Integer> helper = new Stack<>();//单调非递减栈，用来缓存未计算矩形的高度，并定位左边界
    	helper.push(-1);
    	for (int i = 0; i < N; i++) {
			// height[i] 更小，i-1 就是右边界, helper[top-1]+1就是左边界，闭区间
			while(helper.peek()!=-1 && heights[i] <= heights[helper.peek()]) {
				int height = heights[helper.pop()];//高
				int length = (i-1) - helper.peek() ;//宽
				ans = Math.max(ans, height*length);//面积=高*宽
			}
			
			// height[i] 更大，无法定位 helper.peek()的右边界
			helper.push(i);
		}
    	
    	// heights.length-1 是右边界, helper[top-1]+1 是左边界，闭区间
    	while(helper.peek()!=-1) {
    		int height = heights[helper.pop()];
    		int length = (N-1) - helper.peek();
    		ans = Math.max(ans, height*length);
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