package com.jasper.algs.interview.q1704.solu4;

/**
 * 异或特性
 */
public class Solution {

	public int missingNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {//使用异或特性
			ans ^= nums[i];
			ans ^= i;
		}
		
		ans ^= nums.length;
		
		return ans;
    }
	
}
