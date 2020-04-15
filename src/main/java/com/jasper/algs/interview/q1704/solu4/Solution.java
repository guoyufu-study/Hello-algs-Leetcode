package com.jasper.algs.interview.q1704.solu4;

/**
 * 异或特性: 
 * <p>
 * a ^ a = 0
 * <p>
 * 0 ^ a = a
 */
public class Solution {

	public int missingNumber(int[] nums) {
		int ans = 0;
		
		//使用异或特性
		for (int i = 0; i < nums.length; i++) 
			ans ^= nums[i];
		
		int N = nums.length+1;
		for (int i = 1; i <= N; i++) {
			ans ^= i;
		}
		
		return ans;
    }
	
}
