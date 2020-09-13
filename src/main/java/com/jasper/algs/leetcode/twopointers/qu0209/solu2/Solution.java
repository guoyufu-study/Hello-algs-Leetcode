package com.jasper.algs.leetcode.twopointers.qu0209.solu2;

import java.util.Arrays;

/**
 * 0209. 长度最小的子数组
 * 
 * <p> 前缀和 + 二分查找
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int n = nums.length;
    	// 前缀和
    	int[] presums = new int[n+1];
    	for(int i=0; i<n; i++) 
    		presums[i+1] = presums[i] + nums[i];
    	
    	// 二分查找
    	int ans = n+1;
    	for (int i = 0; i < n; i++) {
			int target = presums[i] + s;
			int bound = Arrays.binarySearch(presums, target);
			if(bound<0) bound = -bound-1;
			if(bound<=n) ans = Math.min(ans, bound-i);
		}
    	return ans;
    }
}