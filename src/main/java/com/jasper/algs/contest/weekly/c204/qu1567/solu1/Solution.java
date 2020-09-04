package com.jasper.algs.contest.weekly.c204.qu1567.solu1;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int getMaxLen(int[] nums) {
    	
    	int n = nums.length;
    	// 置 1 0 -1
    	for(int i=0; i<n; i++) 
    		nums[i] = nums[i] < 0 ? -1 : nums[i] == 0 ? 0 : 1;
    	
    	int ans = 0;
    	// 左 -> 右
    	int left = -1, right = 0, multi = 1;
    	while(right < n) {
    		multi *= nums[right];
    		if(multi > 0) {
    			ans = Math.max(ans, right - left);
    		} else if(multi==0) {
    			left = right;
    			multi = 1;
    		}
    		right++;
    	}
    	
    	// 右 -> 左
    	left = n-1; right = n; multi = 1;
    	while(left >= 0) {
    		multi *= nums[left];
    		if(multi > 0) {
    			ans = Math.max(ans, right - left);
    		} else if(multi==0) {
    			right = left;
    			multi = 1;
    		}
    		left--;
    	}
    	
    	return ans;
    }
}