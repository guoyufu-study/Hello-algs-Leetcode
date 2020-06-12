package com.jasper.algs.leetcode.twopointers.qu0015.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0015.三数之和
 * 
 * <p>暴力求解:三层循环
 * 超时
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.parallelSort(nums);//排序
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) break; // 大了，结束
			if(i!=0 && nums[i]==nums[i-1]) continue; // 重复，跳过
			
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j]>0) break; // 大了，结束本轮
				if(j!=i+1 && nums[j]==nums[j-1]) continue; // 重复，跳过
				
				for (int k = j+1; k < nums.length; k++) {
					int sum = nums[i]+nums[j]+nums[k];
					if(sum>0) break; // 大了，结束本轮
					if(sum==0) {//满足条件，记录，结束本轮
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						break;
					}
				}
			}
		}
		return result;
    }

}
