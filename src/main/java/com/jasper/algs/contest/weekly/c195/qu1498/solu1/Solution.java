package com.jasper.algs.contest.weekly.c195.qu1498.solu1;

import java.util.Arrays;

/**
 * 1498. 满足条件的子序列数目
 * 
 * <p> 排序 + 快速幂 + 双指针
 */
class Solution {
	
    private static final int mod = 1_000_000_007;

	public int numSubseq(int[] nums, int target) {
    	
    	Arrays.sort(nums);
    	
    	// 快速幂
    	int n = nums.length;
    	int[] pows = new int[n];
    	pows[0] = 1;
    	for (int i = 1; i < n; i++) {
			pows[i] = (pows[i-1]<<1) % mod ;
		}
    	
    	// 双指针
    	int left = 0, right = n-1, ans = 0;
    	for (; left < n && nums[left]<<1 <= target;) {
			if(nums[left] + nums[right] <= target) {
				ans = (ans + pows[right-left]) % mod;
				left++;
			} else {
				right--;
			}
		}
    	return ans;
    }
}