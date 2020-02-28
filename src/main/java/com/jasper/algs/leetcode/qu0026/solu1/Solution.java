package com.jasper.algs.leetcode.qu0026.solu1;

/**
 * 拷贝覆盖
 */
public class Solution {

	public int removeDuplicates(int[] nums) {

		if(nums.length==1) return 1;
		
		int i = 1;
		for (; i < nums.length; i++) {
			if(nums[i]==nums[i-1]) break;
		}
		
		int ans = i;
		for (; i < nums.length; i++) {
			if(nums[i]!=nums[i-1]) {
				nums[ans++]=nums[i];
			}
		}
		
		return ans;
    }
}
