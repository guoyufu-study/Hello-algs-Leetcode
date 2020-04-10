package com.jasper.algs.leetcode.twopointers.qu0016.solu2;

import java.util.Arrays;

/**
 * 排序+双指针
 */
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		if(nums==null || nums.length<3) 
			throw new IllegalArgumentException("输入数组最少应有3个元素...");
		
		Arrays.sort(nums);//排序
		
		int ans=nums[0]+nums[1]+nums[2];
		for (int i = 0; i < nums.length-2; i++) {//双指针
			int L=i+1, R=nums.length-1;
			while(L<R) {
				int sum = nums[i]+nums[L]+nums[R];
				
				if(Math.abs(target-sum)<Math.abs(target-ans)) ans=sum; //更新答案
				
				if(sum<target) L++; //小了
				else if(sum>target) R--; //大了
				else return target; //最接近值 target
			}
		}
		return ans;
	}
}
