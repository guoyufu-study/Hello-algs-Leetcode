package com.jasper.algs.leetcode.twopointers.qu0042.solu3;

import java.util.Stack;

class Solution {

	public int trap(int[] heights) {
		
		if(heights.length==0) return 0;
		
		// 结果
		int ans = 0;
		
		// 左辅助栈:单调不减
		Stack<Integer> left = new Stack<>();
		for (int height : heights) {
			if(left.isEmpty()) left.push(height);
			left.push(Math.max(left.peek(), height));
		}
		
		int rightMax = heights[heights.length-1];
		for (int i = heights.length-1; i >=0 ; i--) {
			if(rightMax<=heights[i]) // 更新右侧最大值
				rightMax = heights[i];
			else if(left.peek()>heights[i]) //能接雨水
				ans +=Math.min(rightMax, left.peek())-heights[i];
			
			left.pop();
		}
		
		return ans;
    }
}
