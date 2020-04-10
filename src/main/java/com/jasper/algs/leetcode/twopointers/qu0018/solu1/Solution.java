package com.jasper.algs.leetcode.twopointers.qu0018.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力求解：尝试所有组合
 */
class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		Arrays.parallelSort(nums);// 排序，保证不重复
		
		for (int i = 0; i < nums.length; i++) {
			if(i!=0 && nums[i]==nums[i-1]) continue;//重复，跳过
			for (int j = i + 1; j < nums.length; j++) {
				if(j!=i+1 && nums[j]==nums[j-1]) continue;//重复，跳过
				for (int k = j + 1; k < nums.length; k++) {
					if(k != j + 1 && nums[k]==nums[k-1]) continue;//重复，跳过
					for (int m = k + 1; m < nums.length; m++) {
						if(nums[i]+nums[j]+nums[k]+nums[m]==target) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[k]);
							list.add(nums[m]);
							ans.add(list);
							break; //保证不重复
						}
					}
				}
			}
		}
		return ans;
	}
}