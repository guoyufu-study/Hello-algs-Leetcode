package com.jasper.algs.leetcode.twopointers.qu0027.solu2;

/**
 * 交换移除
 */
public class Solution {

	public int removeElement(int[] nums, int val) {
		int ans=0, n=nums.length;
		
		while (ans < n)
			if(nums[ans]!=val)
				ans++;
			else
				nums[ans]=nums[--n];

		return ans;
    }
}
