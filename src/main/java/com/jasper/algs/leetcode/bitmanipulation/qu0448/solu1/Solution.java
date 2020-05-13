package com.jasper.algs.leetcode.bitmanipulation.qu0448.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 原地修改，正负号标识
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	
    	// 原地修改，正负号标识
    	int N = nums.length;
		for (int i = 0; i < N; i++) {
			// 使用了额外空间tmp
			// 计算索引
//			int tmp = nums[i]<0 ? -nums[i]-1 : nums[i]-1;
//			// 数据标负
//			if(nums[tmp] > 0)
//				nums[tmp] =  -nums[tmp];
			
			// 不使用额外空间
			if(nums[i]<0 && nums[-nums[i]-1] > 0) {
    			nums[-nums[i]-1] =  -nums[-nums[i]-1];
    		} else if(nums[i]>0 && nums[nums[i]-1] > 0) {
    			nums[nums[i]-1] =  -nums[nums[i]-1];
    		}
		}
    	
    	// 找出未标识数字
    	List<Integer> ans = new ArrayList<Integer>();
    	for (int i = 0; i < N; i++) {
			if(nums[i]>0)
				ans.add(i+1);
		}
    	
    	return ans;
    }
    
    
    public static void main(String[] args) {
	}
}