package com.jasper.algs.contest.weekly.c192.qu1470.solu1;

/**
 * 1470. 重新排列数组
 * 
 * <p> 辅助数组
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
    	int[] ans = new int[2*n];
    	
        for(int i=0; i<n; i++) {
            ans[2*i] = nums[i];
        }
        
        for(int i=n; i<2*n; i++) {
            ans[2*(i-n)+1] = nums[i];
        }
        
        return ans;
    }
}