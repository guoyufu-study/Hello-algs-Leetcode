package com.jasper.algs.leetcode.twopointers.qu0015.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0015.三数之和
 * 
 * <p>排序+遍历+双指针
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		// 无解
		if(nums == null || nums.length < 3) 
			return new ArrayList<List<Integer>>();
		
		int len = nums.length;
		
		// 排序
		Arrays.parallelSort(nums);
		
		// 整个数组同符号，无解
		if(nums[0]>0 || nums[len-1]<0) 
			return new ArrayList<List<Integer>>();
		
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < len; i++) {//遍历
			if(nums[i]>0) return ans;//同号，无解，结束
			if(i>0 && nums[i]==nums[i-1]) continue;//去重
			
			int L=i+1;//左右指针
			int R=len-1;
			while(L<R) {
				int sum = nums[i]+nums[L]+nums[R];
				if(sum<0) {//小了，左指针前进
					L++;
					continue;
				}
				if(sum>0) {//大了，右指针后退
					R--;
					if(nums[R]<0) break;//同号，无解，结束本次
					continue;
				}
				//相等
				ans.add(Arrays.asList(nums[i],nums[L],nums[R]));//记录
				while(L<R && nums[L]==nums[L+1]) L++;//去重
				while(L<R && nums[R]==nums[R-1]) R--;
				L++;//左右指针逼进
				R--;
			}
		}
		return ans;
    }

}
