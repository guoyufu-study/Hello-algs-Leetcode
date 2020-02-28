package com.jasper.algs.leetcode.qu0283.solu2;

/**
 * 避免无效拷贝
 */
public class Solution {

	public void moveZeroes(int[] nums) {
		int i = 0;
		for (; i < nums.length; i++) {//前段不为0的值不动。
			if(nums[i]==0) break;
		}

		int curr=i;
		for (; i < nums.length; i++) {//非0值前移
			if(nums[i]!=0) {
				nums[curr]=nums[i];
				curr++;
			}
		}
		for (; curr < nums.length; curr++) {//剩余位置补0
			nums[curr]=0;
		}
    }
}
