package com.jasper.algs.leetcode.bitmanipulation.qu0442.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0442. 数组中重复的数据
 * 
 * <p> 正负号标识
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {

    	ArrayList<Integer> ans = new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) { // 计算索引
				if(nums[nums[i]-1]>0) // 第一次出现
					nums[nums[i]-1] = - nums[nums[i]-1];
				else ans.add(nums[i]); // 第二次出现
			} else {// 计算索引
				if(nums[-nums[i]-1]>0) // 第一次出现
					nums[-nums[i]-1] = - nums[-nums[i]-1];
				else ans.add(-nums[i]); // 第二次出现
			}
		}
    	
    	return ans;
    }
}