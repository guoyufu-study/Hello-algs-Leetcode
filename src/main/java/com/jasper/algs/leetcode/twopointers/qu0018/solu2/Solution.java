package com.jasper.algs.leetcode.twopointers.qu0018.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0018. 四数之和
 * 
 * <p>转成三数求和
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int len = nums.length;
		
		// 排序
		Arrays.parallelSort(nums);
		
		// 四数
		for (int i = 0; i < len-3; i++) {
			if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;//大了，结束
			if(nums[i]+nums[len-3]+nums[len-2]+nums[len-1]<target) {//小了，跳过
				while(i<len-4 && nums[i]==nums[i+1]) i++;//去重
				continue;
			}
			
			// 三数
			for (int j = i+1; j < len-2; j++) {
				if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;//大了，结束
				if(nums[i]+nums[j]+nums[len-2]+nums[len-1]<target) {//小了，跳过
					while(j<len-3 && nums[j]==nums[j+1]) j++;//去重
					continue;
				}
				
				int L=j+1;//左右指针
				int R=len-1;
				while(L<R) {
					int sum = nums[i]+nums[j]+nums[L]+nums[R];
					if(sum<target) {//小了，左指针前进
						while(L<R && nums[L]==nums[L+1]) L++;//去重
						L++;
						continue;
					}
					if(sum>target) {//大了，右指针后退
						while(L<R && nums[R]==nums[R-1]) R--;//去重
						R--;
						continue;
					}
					//相等
					ans.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));//记录
					while(L<R && nums[L]==nums[L+1]) L++;//去重
					while(L<R && nums[R]==nums[R-1]) R--;
					L++;//左右指针逼进
					R--;
				}
                while(j<len-3 && nums[j]==nums[j+1]) j++;//去重
			}

           while(i<len-4 && nums[i]==nums[i+1]) i++;//去重
		}
		return ans;
    }
}