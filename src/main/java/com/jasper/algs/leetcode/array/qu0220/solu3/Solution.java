package com.jasper.algs.leetcode.array.qu0220.solu3;

import java.util.HashMap;
import java.util.Map;

/**
 * 0220. 存在重复元素 III
 * 
 * <p> 桶
 */
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    int n = nums.length;
	    Map<Long, Long> map = new HashMap<>();
	    long w = (long)t+1;
	    for(int i=0; i<n; i++) {
	    	long key = getKey(nums[i], w);
	    	if(map.containsKey(key)) return true;
	    	if(map.containsKey(key-1) && nums[i]-map.get(key-1)<=t) return true;
	    	if(map.containsKey(key+1) && map.get(key+1)-nums[i]<=t) return true;
	    	map.put(key, (long)nums[i]);
	    	if(i>=k) map.remove(getKey(nums[i-k], w));
	    }
	    return false;
	}

	private long getKey(long num, long w) {
		return num<0 ? (num+1)/w-1 : num/w;
	}
}
