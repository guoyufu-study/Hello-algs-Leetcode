package com.jasper.algs.leetcode.array.qu0080.solu1;

/**
 * 拷贝覆盖
 */
public class Solution {

	public int removeDuplicates(int[] nums) {

		if(nums==null) return 0;
		else if(nums.length<=2) return nums.length;
		
		//双指针
		int i=2;
		for (; i < nums.length; i++) // 跳到第一个要移除的元素的位置
			if(nums[i]==nums[i-2]) break;
			
		int ans=i;
		for (; i < nums.length; i++) {
			if(nums[i]!=nums[ans-2]) {
				nums[ans++] = nums[i];
			}
		}
		
		return ans;
    }
}
