package com.jasper.algs.leetcode.binarysearch.qu0154.solu1;

/**
 * 0154. 寻找旋转排序数组中的最小值 II
 * 
 * <p> 二分查找
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low < high) {
            int pivot = low + ((high-low)>>1);
            if(nums[pivot] < nums[high]) high = pivot;
            else if(nums[pivot] > nums[high]) low = pivot+1;
            else high--;
        }

        return nums[low];
    }
}