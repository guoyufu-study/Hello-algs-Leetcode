package com.jasper.algs.leetcode.stack.qu0503.solu1;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	public int[] nextGreaterElements(int[] nums) {
		// 结果
		int ans[] = new int[nums.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = -1;
		}
		// 辅助栈
		Stack<Integer> stack = new Stack<>();
		
		// 填充字典
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i]>nums[stack.peek()]) {
				ans[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i]>nums[stack.peek()]) {
				ans[stack.pop()] = nums[i];
			}
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {100,1,11,1,120,111,123,1,-1,-100};
		int[] ans = new Solution().nextGreaterElements(nums);
		Arrays.stream(ans).forEach(System.out::println);
//		[120,11,120,120,123,123,-1,100,100,100]
	}
}
