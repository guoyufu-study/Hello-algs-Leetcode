package com.jasper.algs.leetcode.twopointers.qu0042.solu3;

import java.util.Stack;

/**
 * 3. 一个辅助栈
 * 
 * <p>优化双辅助数组
 */
class Solution {

	public int trap(int[] heights) {
		// 边界值
		if(heights.length<=2) return 0;
		
		// 结果
		int ans = 0;
		
		// 左挡板:单调不减
		Stack<Integer> left = new Stack<>();
		for (int height : heights) {
			if(left.isEmpty()) left.push(height);
			left.push(Math.max(left.peek(), height));
		}
		
		int rightMax = heights[heights.length-1];
		for (int i = heights.length-1; i >=0 ; i--) {
			if(rightMax<=heights[i]) // 不能接雨水
				rightMax = heights[i]; // 更新右侧最大值
			else if(left.peek()>heights[i]) //能接雨水
				ans +=Math.min(rightMax, left.peek())-heights[i]; // 接
			
			left.pop();
		}
		
		return ans;
    }
}
