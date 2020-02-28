package com.jasper.algs.interview.q1704.solu2;

/**
 * 求和相减
 * 
 * <p>缺点：有可能溢出
 */
public class Solution {

	public int missingNumber(int[] nums) {
		int threshold = (1<<16)-1;
		int n = nums.length;
		if(n>threshold) {//有可能溢出
			throw new IllegalArgumentException("n最大不超过"+threshold);
		}
		int ans = (n+1)*n/2;
		
		for (int i = 0; i < nums.length; i++) {
			ans -= nums[i];
		}

		return ans;
    }
	
}
