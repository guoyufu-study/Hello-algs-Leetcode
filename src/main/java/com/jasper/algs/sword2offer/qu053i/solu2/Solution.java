package com.jasper.algs.sword2offer.qu053i.solu2;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 
 * <p> 二分查找
 */
class Solution {
    public int search(int[] nums, int target) {
        // 二分查找
        int left = 0, n = nums.length, right = n-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else {
                return count(nums, mid);
            }
        }

        return 0;
    }

    int count(int[] nums, int index) {
        int count = 1;
        for(int i=index-1; i>=0 && nums[i]==nums[index]; i--) {
            count++;
        }

        for(int i=index+1; i<nums.length && nums[i]==nums[index]; i++) {
            count++;
        }
        return count;
    }
}