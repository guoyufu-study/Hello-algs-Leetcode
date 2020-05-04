package com.jasper.algs.leetcode.twopointers.qu0080.solu1;

/**
 * 0080.删除有序数组中的重复项II
 * 
 * <p>
 * 同向指针：拷贝覆盖
 */
public class Solution {

	public int removeDuplicates(int[] nums) {
		
		int k = 2;
		
		// 边界
		if(nums==null) return 0;
		if(nums.length<=k) return nums.length;
		
		// 跳到第一个要移除的元素的位置
		int i=2;
		for (; i < nums.length; i++)
			if(nums[i]==nums[i-k]) break;
			
		// 同向指针：拷贝覆盖
		int ans=i;
		for (; i < nums.length; i++)
			if(nums[i]!=nums[ans-2])
				nums[ans++] = nums[i];
		
		return ans;
    }
}
