package com.jasper.algs.leetcode.binarysearch.qu0153.solu1;

/**
 * 0153. 寻找旋转排序数组中的最小值
 * 
 * <p> 二分查找
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low < high) {
            int pivot = low + ((high - low) >> 1);
            if(nums[pivot] < nums[high]) high = pivot;
            else low = pivot + 1;
        }

        return nums[low];
    }
}