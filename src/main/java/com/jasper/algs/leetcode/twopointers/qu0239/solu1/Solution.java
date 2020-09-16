package com.jasper.algs.leetcode.twopointers.qu0239.solu1;

/**
 * 0239. 滑动窗口最大值
 *
 * <p> 暴力法（超时）
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	
    	int n = nums.length;
    	int[] ans = new int[n-k+1];
		for (int i = 0; i + k - 1 < n ; i++) {
			ans[i] = nums[i];
			for (int j = 1; j < k; j++) {
				int index = j+i;
				ans[i] = Math.max(ans[i], nums[index]);
			}
		}
    	
    	return ans;
    }
}