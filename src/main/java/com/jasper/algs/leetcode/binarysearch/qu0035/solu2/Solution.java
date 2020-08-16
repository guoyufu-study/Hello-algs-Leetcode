package com.jasper.algs.leetcode.binarysearch.qu0035.solu2;

/**
 * 0035. 搜索插入位置
 *
 * <p> 二分查找
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int min = 0, n = nums.length, max = n-1;

        while(min <= max) {
            int mid = (min+max)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target) 
                max = mid -1;
            else {
                min = mid + 1;
            }
        }

        return max+1;
    }
}