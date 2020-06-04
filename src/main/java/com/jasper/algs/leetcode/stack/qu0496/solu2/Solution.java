package com.jasper.algs.leetcode.stack.qu0496.solu2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 0496. 下一个更大的元素 I
 * 
 * <p> 辅助字典+辅助栈
 */
class Solution {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		// key：nums2 值 -> value：nums2 中下一个更大的值
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		// 单调栈
		Stack<Integer> stack = new Stack<Integer>();
		
		// 找下一个更大值，并存入字典
		for (int i = 0; i < nums2.length; i++) {
			while(!stack.isEmpty() && nums2[i]>stack.peek())
				map.put(stack.pop(), nums2[i]);
			stack.push(nums2[i]);
		}
		// 没有找到下一个更大值，存 -1 入字典
		while(!stack.isEmpty())
			map.put(stack.pop(), -1);
		
		// 构造答案
		for (int i = 0; i < nums1.length; i++)
			nums1[i] = map.get(nums1[i]);
		
		return nums1;
	}
	
	public static void main(String[] args) {
    	// -1,3,-1
		int[] nums1 = new int[] {4,1,2};
		int[] nums2 = new int[] {1,3,4,2};
		
		// 3,-1
//		int[] nums1 = new int[] {2,4};
//		int[] nums2 = new int[] {1,2,3,4};
		
    	// [-1,-1,-1,-1,-1]
//		int[] nums1 = new int[] {1,3,5,2,4};
//		int[] nums2 = new int[] {5,4,3,2,1};
		
		IntStream.of(new Solution().nextGreaterElement(nums1, nums2))
			.forEach( num -> {
				System.out.print(num + ",");
			});
	}
}
