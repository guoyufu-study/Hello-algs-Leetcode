package com.jasper.algs.interview.q1719.solu2;

import java.util.Arrays;

/**
 * 求和相减
 */
class Solution {
    public int[] missingTwo(int[] nums) {
    	int[] ans = new int[2];
    	
    	// 求缺失的两数之和
    	int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int sumOfTwo = (nums.length+2)*(nums.length+3)/2 - sum;
    	
		// 求较小的缺失数
		int threadhold = sumOfTwo/2;
		sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<=threadhold) // 排除 较大的缺失数
				sum += nums[i];
		}
		ans[0] = threadhold * (1+threadhold)/2 - sum;
		
		// 另一个缺失的数
		ans[1] = sumOfTwo - ans[0];
		
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = new int[] {2};
		
		int[] ans = new Solution().missingTwo(nums);
		
		Arrays.stream(ans).forEach(System.out::println);
	}
}