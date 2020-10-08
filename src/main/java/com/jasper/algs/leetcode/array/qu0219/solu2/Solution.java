package com.jasper.algs.leetcode.array.qu0219.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0219. 存在重复元素 II
 * 
 * <p> 辅助字典：散列表
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
		for(int index=0; index<n; index++) {
            if(map.containsKey(nums[index]) && map.get(nums[index])+k>=index)
                return true;
            map.put(nums[index], index);
        }
        return false;
    }
}