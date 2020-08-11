package com.jasper.algs.leetcode.array.qu0219.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0219. 存在重复元素 II
 * 
 * <p> 辅助字典
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

    	// 辅助字典
        int n = nums.length;
        if(n==0) return false;
        Map<Integer, Integer> helper = new HashMap<Integer, Integer>();
        helper.put(nums[0], 0);
        for(int i=1; i<n; i++) {
            if(i - helper.getOrDefault(nums[i], -k) <= k) {
                return true;
            }
            helper.put(nums[i], i);
        }

        return false;
    }
}