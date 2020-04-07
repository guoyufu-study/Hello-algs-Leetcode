package com.jasper.algs.leetcode.stack.qu0496.solu2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 辅助字典+辅助栈
 */
class Solution {

	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		// 辅助字典
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		// 辅助栈
		Stack<Integer> stack = new Stack<Integer>();
		
		// 填充辅助字典
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i]>stack.peek())
				map.put(stack.pop(), nums[i]);
			stack.push(nums[i]);
		}
		while(!stack.isEmpty())
			map.put(stack.pop(), -1);
		
		// 找大值
		for (int i = 0; i < findNums.length; i++)
			findNums[i] = map.get(findNums[i]);
		
		return findNums;
	}
}
