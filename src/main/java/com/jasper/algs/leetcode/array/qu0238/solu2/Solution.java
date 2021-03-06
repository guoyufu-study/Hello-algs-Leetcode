package com.jasper.algs.leetcode.array.qu0238.solu2;

import java.util.stream.IntStream;

/**
 * 0238. 除自身以外数组的乘积
 * 
 * <p>左侧乘积*右侧乘积
 */
class Solution {
	public int[] productExceptSelf(int[] nums) {
		int N = nums.length;
		int[] ans = new int[N];
		
		// 左侧乘积
		ans[0] = 1;
		for (int i = 1; i < N; i++) {
			ans[i] = ans[i-1] * nums[i-1];
		}
		
		// 右侧乘积
		int R = 1;
		for (int i = N-2; i >= 0; i--) {
			R *= nums[i+1];
			
			// 两侧相乘
			ans[i] *= R;
		}
		
		return ans;
    }
	
	public static void main(String[] args) {
		// [24,12,8,6]
		int[] nums = new int[] {1,2,3,4};
		
		IntStream.of(new Solution().productExceptSelf(nums))
			.forEach(x -> System.out.print(x + ","));
	}
}