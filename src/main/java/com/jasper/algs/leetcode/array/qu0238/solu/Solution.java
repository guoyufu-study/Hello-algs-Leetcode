package com.jasper.algs.leetcode.array.qu0238.solu;

import java.util.stream.IntStream;

/**
 * 0238. 除自身以外数组的乘积
 * 
 * <p> 3 刷
 */
class Solution {
	public int[] productExceptSelf(int[] nums) {
		int N = nums.length;
		int[] ans = new int[N];
		
		return ans;
    }
	
	public static void main(String[] args) {
		// [24,12,8,6]
		int[] nums = new int[] {1,2,3,4};
		
		IntStream.of(new Solution().productExceptSelf(nums))
			.forEach(x -> System.out.print(x + ","));
	}
}
