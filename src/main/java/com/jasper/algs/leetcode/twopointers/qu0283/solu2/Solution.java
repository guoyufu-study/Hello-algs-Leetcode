package com.jasper.algs.leetcode.twopointers.qu0283.solu2;

/**
 * 避免无效拷贝
 */
public class Solution {

	public void moveZeroes(int[] nums) {
		int right = 0;//右指针
		for (; right < nums.length; right++) {//前段非0值不动。
			if(nums[right]==0) break;
		}

		int left=right;//左指针
		for (; right < nums.length; right++) {//非0值前移
			if(nums[right]!=0) 
				nums[left++]=nums[right];
		}
		
		// 补零值
		while(left < nums.length) {
			nums[left++]=0;//剩余位置补0
		}
    }
}
