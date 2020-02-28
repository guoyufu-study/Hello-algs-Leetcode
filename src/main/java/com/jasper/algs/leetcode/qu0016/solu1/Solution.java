package com.jasper.algs.leetcode.qu0016.solu1;

/**
 * 暴力求解：三层循环
 */
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		if(nums==null || nums.length<3) 
			throw new IllegalArgumentException("输入数组最少应有3个元素...");
		
		int ans=nums[0]+nums[1]+nums[2];
		for (int i = 0; i < nums.length; i++) {//三层循环
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					int sum = nums[i]+nums[j]+nums[k];//求和
					if(sum==target) return target; //最接近值 target
					if(Math.abs(target-sum)<Math.abs(target-ans)) //更新答案
						ans = sum;
				}
			}
		}
		return ans;
	}
}
