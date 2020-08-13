package com.jasper.algs.leetcode.hashmap.qu0532.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 0532. 数组中的K-diff数对
 * 
 * <p> 辅助字典
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        // 边界
        if(k<0) return 0;

        Set<Integer> helper = new HashSet<Integer>();
        Set<Integer> smaller = new HashSet<Integer>();

        for(int num : nums) {
            if(helper.contains(num-k)) {
                smaller.add(num-k);
            }

            if(helper.contains(k+num)) {
                smaller.add(num);
            }

            helper.add(num);
        }

        return smaller.size();
    }
}