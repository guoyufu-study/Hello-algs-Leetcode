package com.jasper.algs.leetcode.dp.qu0325.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0325. 和等于 k 的最长子数组长度
 * 
 * <p> 动态规划（前缀和） + 辅助字典
 */
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
    	
    	Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
    	dp.put(0, -1);
    	int sum = 0, ans = 0, n = nums.length;
    	for (int index = 0; index < n; index++) {
    		sum += nums[index];
			if(!dp.containsKey(sum)) dp.put(sum, index);// 预存前缀和
			ans = Math.max(ans, index - dp.getOrDefault(sum-k, index)); // 计算子数组长度
		}
    	return ans;
    }
}