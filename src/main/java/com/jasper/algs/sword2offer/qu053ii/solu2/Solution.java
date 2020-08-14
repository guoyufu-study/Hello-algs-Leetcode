package com.jasper.algs.sword2offer.qu053ii.solu2;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 
 * <p> 二分查找
 */
class Solution {
    public int missingNumber(int[] nums) {
    	
    	int n = nums.length, left = 0, right = n-1;
    	
    	while(left<right) {
    		int mid = (left+right)/2;
    		if(nums[mid]==mid) left = mid + 1;
    		else right = mid;
    	}
    	
    	return nums[left]==left ? left + 1 : left;
    }
}