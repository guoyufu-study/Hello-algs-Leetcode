package com.jasper.algs.leetcode.twopointers.qu0209.solu3;

/**
 * 0209. 长度最小的子数组
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int n=nums.length, ans=n+1;
    	int start=0, end=0, sum=0;// []左闭右闭
    	while(end < n) {
    		sum += nums[end];
    		while(sum >= s) {
    			ans = Math.min(ans, end-start+1);
    			sum -= nums[start];
    			start++;
    		}
    		end++;
    	}
    	return ans==n+1 ? 0 : ans;
    }
}