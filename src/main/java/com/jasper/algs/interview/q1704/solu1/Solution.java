package com.jasper.algs.interview.q1704.solu1;

/**
 * 暴力求解：双层循环
 */
public class Solution {

	public int missingNumber(int[] nums) {
		int n = nums.length;
		for (int ans = 0; ans <= n; ans++) {
			boolean contained = false;
			for (int i = 0; i < nums.length; i++) {
				if(ans==nums[i]) {
					contained = true;
					break;
				}
			}
			if(!contained) return ans;
		}
		return -1;
    }
	
}
