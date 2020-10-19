package com.jasper.algs.leetcode.hashmap.qu0001.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0001.两数之和
 * 
 * <p>两遍哈希表：先存再找
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
