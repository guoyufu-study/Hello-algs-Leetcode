package com.jasper.algs.leetcode.hashmap.qu0523.solu3;

import java.util.HashMap;
import java.util.Map;

/**
 * 0523. 连续的子数组和
 * 
 * <p> 前缀和 + 辅助字典
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    	int n = nums.length, sum = 0;
    	Map<Integer,Integer> helper = new HashMap<Integer, Integer>();
    	helper.put(0, -1); // sum%k -> index
    	for (int i = 0; i < n; i++) {
			sum += nums[i];
			if(k!=0) sum %= k;
			if(helper.containsKey(sum)) {
				if(i-helper.get(sum)>=2) // 解决 [a, n*k, b] 的形式 
					return true;
			} else
				helper.put(sum, i);
		}
    	return false;
    }
}