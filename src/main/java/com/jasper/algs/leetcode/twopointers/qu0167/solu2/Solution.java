package com.jasper.algs.leetcode.twopointers.qu0167.solu2;

/**
 * 双指针
 */
public class Solution {
	
	public int[] twoSum(int[] nums, int target) {
		// 每个输入只对应唯一的答案 => 不会有重复元素 => 不用考虑去重问题
		int L=0, R=nums.length-1;
		while(L<R) {
			int sum = nums[L]+nums[R];//求和，不考虑溢出问题
			if(sum==target) return new int[] {L+1,R+1};
			else if(sum<target) L++;//小了
			else R--;//大了
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
