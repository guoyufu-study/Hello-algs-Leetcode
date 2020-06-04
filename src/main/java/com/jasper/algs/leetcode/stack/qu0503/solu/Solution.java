package com.jasper.algs.leetcode.stack.qu0503.solu;

import java.util.Arrays;

/**
 * 0503. 下一个更大的元素 II
 * 
 * <p> 3刷
 */
public class Solution {

	public int[] nextGreaterElements(int[] nums) {
		
		return new int[0];
	}
	
	
	public static void main(String[] args) {
		// [120,11,120,120,123,123,-1,100,100,100]
		int[] nums = new int[] {100,1,11,1,120,111,123,1,-1,-100};
		
		// 2,-1,2
//		int[] nums = new int[] {1,2,1};
		
		Arrays.stream(new Solution().nextGreaterElements(nums))
			.forEach( x -> {
				System.out.print(x + ",");
			});
	}
}
