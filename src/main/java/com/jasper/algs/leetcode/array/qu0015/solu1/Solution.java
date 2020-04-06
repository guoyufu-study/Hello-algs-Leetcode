package com.jasper.algs.leetcode.array.qu0015.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力求解:三层循环
 * 超时
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.parallelSort(nums);//排序
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++)//所有组合
					if(nums[i]+nums[j]+nums[k]==0 && //判断
						isNotIn(result, nums[i], nums[j])) {//判重
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));//记录
					}
			}
		}
		return result;
    }

	private boolean isNotIn(List<List<Integer>> result, int i, int j) {
		for (List<Integer> list : result) {
			if(list.get(0)==i && list.get(1)==j)
				return false;
		}
		return true;
	}
}
