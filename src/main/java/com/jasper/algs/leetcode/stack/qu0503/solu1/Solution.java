package com.jasper.algs.leetcode.stack.qu0503.solu1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 0503. 下一个更大的元素 II
 * 
 * <p> 单调栈 + 辅助字典
 */
public class Solution {

	public int[] nextGreaterElements(int[] nums) {
		// 结果
		int ans[] = new int[nums.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = -1;
		}
		// 辅助栈
		Stack<Integer> stack = new Stack<>();
		
		// 找到下一个更大值
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i]>nums[stack.peek()]) {
				ans[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		
		// 循环数组，找到下一个更大值
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i]>nums[stack.peek()]) {
				ans[stack.pop()] = nums[i];
			}
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		// [120,11,120,120,123,123,-1,100,100,100]
//		int[] nums = new int[] {100,1,11,1,120,111,123,1,-1,-100};
		
		// 2,-1,2
		int[] nums = new int[] {1,2,1};
		
		Arrays.stream(new Solution().nextGreaterElements(nums))
			.forEach( x -> {
				System.out.print(x + ",");
			});
	}
}
