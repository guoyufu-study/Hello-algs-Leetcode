package com.jasper.algs.leetcode.array.qu0169.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 辅助字典
 */
class Solution {
    public int majorityElement(int[] nums) {
    	// 辅助字典
    	Map<Integer, Integer> helper = new HashMap<>();
    	
    	// 计数，找众数
    	int n = nums.length;
		for (int i = 0; i < n; i++) {
			helper.put(nums[i], helper.getOrDefault(nums[i], 0)+1);
			if(helper.get(nums[i]) > n/2)
				return nums[i];
		}
		
        throw new IllegalArgumentException("没有众数！");
    }
}