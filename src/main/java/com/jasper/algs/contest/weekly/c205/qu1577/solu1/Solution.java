package com.jasper.algs.contest.weekly.c205.qu1577.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1577. 数的平方等于两数乘积的方法数
 * 
 * <p> 辅助字典
 */
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
    	return count(nums1, nums2) + count(nums2, nums1);
    }

	int count(int[] nums1, int[] nums2) {
		Map<Long,Integer> map = new HashMap<Long, Integer>();
		for(int num : nums1) 
			map.compute((long)num*num, (k, v) -> v==null ? 1 : v+1);
		
		int n = nums2.length, ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				ans += map.getOrDefault((long)nums2[i]*nums2[j], 0);
			}
		}
		return ans;
	}
}