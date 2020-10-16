package com.jasper.algs.leetcode.array.qu0220.solu1;

/**
 * 0220. 存在重复元素 III
 * 
 * <p> 暴力枚举（超时）
 */
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    int n = nums.length;
		for (int i = 0; i < n; ++i) {
	        for (int j = Math.max(i - k, 0); j < i; ++j) {
	            if (Math.abs(nums[i] - 0L - nums[j]) <= t) return true;
	        }
	    }
	    return false;
	}
}
