package com.jasper.algs.leetcode.array.qu0217.solu3;

import java.util.HashSet;
import java.util.Set;

/**
 * 0217. 存在重复元素
 * 
 * <p> 辅助字典
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {

    	Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}