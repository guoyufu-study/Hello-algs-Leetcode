package com.jasper.algs.leetcode.array.qu0219.solu3;

import java.util.HashSet;
import java.util.Set;

/**
 * 0219. 存在重复元素 II
 * 
 * <p> 定长辅助字典
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

    	// 辅助字典
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}