package com.jasper.algs.leetcode.twopointers.qu0026.solu1;

/**
 * 0026.删除有序数组中的重复项
 * 
 * <p> 双指针：拷贝覆盖
 */
public class Solution {

	public int removeDuplicates(int[] nums) {

		// 边界
		int k = 1;
		if(nums==null) return 0;
		if(nums.length<=k) return nums.length;
		
		int N = nums.length;
		
		// 无需修改部分：跳过
		int i = k;
		for (; i < N; i++) {
			if(nums[i]==nums[i-k]) break;
		}
		
		// 需要修改部分：拷贝覆盖
		int ans = i;
		for (; i < N; i++)
			if(nums[i]!=nums[i-1])
				nums[ans++]=nums[i];
		
		return ans;
    }
}
