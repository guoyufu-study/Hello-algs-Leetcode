package com.jasper.algs.leetcode.array.qu0220.solu2;

import java.util.TreeSet;

/**
 * 0220. 存在重复元素 III
 * 
 * <p> 二叉搜索树 TreeSet
 */
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    int n = nums.length;
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i=0; i<n; i++) {
			Integer ceiling = ts.ceiling(nums[i]);
			if(ceiling!=null && ceiling-nums[i]<=t) return true;
			Integer floor = ts.floor(nums[i]);
			if(floor!=null && nums[i]-floor<=t) return true;
			
			ts.add(nums[i]);
			if(ts.size()>k) ts.remove(nums[i-k]);
		}
	    return false;
	}
}
