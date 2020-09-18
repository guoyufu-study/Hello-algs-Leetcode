package com.jasper.algs.leetcode.binarysearch.qu0081.solu1;

/**
 * 0081. 搜索旋转排序数组 II
 * 
 * <p> 清理首尾重复元素 + 二分查找
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        // 二分查找
        int left = 0, right = n-1;
        while(left <= right) {
            while(left<right && nums[left]==nums[right]) left++; // 清理首尾重复元素
            int pivot = left + (right-left)/2;
            if(nums[pivot]==target) return true;
            if(nums[left] <= nums[pivot]) { // 前段有序
                if(nums[left] <= target && target < nums[pivot]) right = pivot - 1;
                else left = pivot + 1;
            } else {// 后段有序
                if(nums[pivot] < target && target <= nums[right]) left = pivot + 1;
                else right = pivot - 1;
            }
        }

        return false;
    }
}