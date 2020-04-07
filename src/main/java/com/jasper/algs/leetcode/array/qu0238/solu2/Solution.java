package com.jasper.algs.leetcode.array.qu0238.solu2;

/**
 * 左侧乘积*右侧乘积
 */
class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		
		// 左侧乘积
		ans[0] = 1;
		for (int i = 1; i < ans.length; i++) {
			ans[i] = ans[i-1]*nums[i-1];
		}
		
		int k=1;
		for (int i = ans.length-2; i >= 0; i--) {
			k *= nums[i+1];//右侧乘积
			ans[i] *= k;
		}
		return ans;
    }
}
