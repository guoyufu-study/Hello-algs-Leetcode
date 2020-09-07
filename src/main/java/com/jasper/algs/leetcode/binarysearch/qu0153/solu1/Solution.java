package com.jasper.algs.leetcode.binarysearch.qu0153.solu1;

/**
 * 0153. 寻找旋转排序数组中的最小值
 * 
 * <p> 二分查找
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            if(nums[left] < nums[right]) return nums[left];
            int mid = (left+right)/2;
            if(nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                 right = mid;
            }
        }

        return nums[left];
    }

}