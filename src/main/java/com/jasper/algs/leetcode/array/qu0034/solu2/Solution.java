package com.jasper.algs.leetcode.array.qu0034.solu2;

/**
 * 0034. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * <p> 二分查找
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
    
    	int n = nums.length, left = 0, right = n-1;
    	while(left <= right) {
    		int mid = (left + right) / 2;
    		if(nums[mid] < target) left = mid + 1;
    		else if(nums[mid] > target) right = mid -1;
    		else {
    			// 找到
    			left = mid;
    			while(left >= 0 && nums[left] == target) left--;
    			right = mid;
    			while(right<n && nums[right] == target) right++;
    			return new int[] {left+1, right-1};
    		}
    	}
    	return new int[] {-1, -1};
    }
}