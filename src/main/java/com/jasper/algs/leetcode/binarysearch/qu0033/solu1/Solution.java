package com.jasper.algs.leetcode.binarysearch.qu0033.solu1;

/**
 * 0033. 搜索旋转排序数组
 * 
 * <p> 二分查找
 */
class Solution {
    public int search(int[] nums, int target) {
    	// 二分查找
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right) {
            int pivot = left + (right-left)/2;
            if(nums[pivot]==target) return pivot; // 找到
            if(nums[pivot] > nums[right]) { // 前段有序
                if(nums[left] <= target && target < nums[pivot]) right = pivot - 1; 
                else left = pivot + 1;
            } else {// 后段有序
                if(nums[pivot] < target && target <= nums[right]) left = pivot + 1;
                else right = pivot - 1;
            }
        }

        return -1;
    }
}