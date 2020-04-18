package com.jasper.algs.leetcode.twopointers.qu0167.solu2;

/**
 * 双指针
 */
public class Solution {
	
	public int[] twoSum(int[] numbers, int target) {
		// 数组长度不符合要求
		int n = numbers.length;
		if(n<2) 
			throw new IllegalArgumentException("No two sum solution");

		// 最小值仍然大了
		int minSum = numbers[0]+numbers[1];
		if(minSum == target) return new int[] {1, 2};
		else if(minSum>target) throw new IllegalArgumentException("No two sum solution");
		
		// 最大值仍然小了
		int maxSum = numbers[n-1]+numbers[n-2];
		if(maxSum == target) return new int[] {n-1, n};
		else if(maxSum<target) throw new IllegalArgumentException("No two sum solution");
		
		
		// 每个输入只对应唯一的答案 => 不会有重复元素 => 不用考虑去重问题
		int L=0, R=n-1;
		while(L<R) {
			int sum = numbers[L]+numbers[R];//求和，不考虑溢出问题
			if(sum==target) return new int[] {L+1,R+1};
			else if(sum<target) L++;//小了
			else R--;//大了
		}
		
		// 没有结果
		throw new IllegalArgumentException("No two sum solution");
	}
}
