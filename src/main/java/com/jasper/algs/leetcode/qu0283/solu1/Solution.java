package com.jasper.algs.leetcode.qu0283.solu1;

/**
 * 拷贝覆盖
 */
public class Solution {

	public void moveZeroes(int[] nums) {
		int curr=0;
		for (int num : nums) {
			if(num!=0) {
				nums[curr]=num;
				curr++;
			}
		}
		
		for (int i = curr; i < nums.length; i++) {
			nums[i]=0;
		}
    }
}
