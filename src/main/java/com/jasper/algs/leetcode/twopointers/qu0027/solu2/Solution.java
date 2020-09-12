package com.jasper.algs.leetcode.twopointers.qu0027.solu2;

/**
 * 0027.移除元素
 * 
 * <p>左右指针：交换移除
 */
public class Solution {

	public int removeElement(int[] nums, int val) {
		int left=0, n=nums.length, right=n-1;
		
		while (left <= right)
			if(nums[left]!=val) left++;
			else nums[left]=nums[right--];

		return left;
    }
}
