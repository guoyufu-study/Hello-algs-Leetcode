package com.jasper.algs.leetcode.hashmap.qu0560.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0560. 和为K的子数组
 * 
 * <p> 前缀和
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
    	
    	int ans = 0;
    	
    	// 辅助字典： 前缀和 -> 数量
    	Map<Integer,Integer> helper = new HashMap<Integer, Integer>();
    	helper.put(0, 1);
    	int sum = 0;
    	for (int end = 0; end < nums.length; end++) {
    		sum += nums[end];
			int key = sum - k;
			// 查字典
			if(helper.containsKey(key))
				ans += helper.get(key); // 计数
			// 存字典
			helper.put(sum, helper.getOrDefault(sum, 0)+1);
		}
    	
    	return ans;
    }
}