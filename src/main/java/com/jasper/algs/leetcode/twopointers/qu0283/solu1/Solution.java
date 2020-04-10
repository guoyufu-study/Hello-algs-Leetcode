package com.jasper.algs.leetcode.twopointers.qu0283.solu1;

/**
 * 拷贝覆盖
 */
public class Solution {

	public void moveZeroes(int[] nums) {
		
		// 移动非零
		int left=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) 
				nums[left++] = nums[i];
		}
		
		// 置零
		for (int i = left; i < nums.length; i++) {
			nums[i]=0;
		}
    }
}
