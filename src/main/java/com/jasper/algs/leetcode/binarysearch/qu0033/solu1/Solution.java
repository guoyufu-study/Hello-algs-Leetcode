package com.jasper.algs.leetcode.binarysearch.qu0033.solu1;

/**
 * 0033. 搜索旋转排序数组
 * 
 * <p> 二分查找
 */
class Solution {
    public int search(int[] nums, int target) {
    	int n = nums.length, left = 0, right = n-1;
    	while(left <= right) {
    		int mid = left + (right - left) / 2;
    		if(nums[mid]==target) return mid;
    		
    		if(nums[mid] < target) { // 小了
    			if(nums[left] <= nums[mid]) left = mid + 1;
    			else if(nums[left] <= target) right = mid - 1;
    			else left = mid + 1;
    		} else { // 大了
    			if(nums[left] > nums[mid]) right = mid - 1;
    			else if(nums[left] > target) left = mid + 1;
    			else right = mid - 1;
    		}
    	}
    	
    	return -1;
    }
}