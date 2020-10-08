package com.jasper.algs.leetcode.array.qu0219.solu3;

import java.util.HashSet;
import java.util.Set;

/**
 * 0219. 存在重复元素 II
 * 
 * <p> 辅助字典：定长集合
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
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