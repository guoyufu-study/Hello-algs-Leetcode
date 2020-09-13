package com.jasper.algs.leetcode.twopointers.qu0209.solu1;

/**
 * 0209. 长度最小的子数组
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int n = nums.length, ans = n+1;
    	for (int i = 0; i < n; i++) {
    		int sum = nums[i];
    		int j = i+1;
			while(j < n && sum < s) 
				sum += nums[j++];
			if(sum>=s) ans = Math.min(ans, j-i);
		}
    	return ans==n+1 ? 0 : ans;
    }
}