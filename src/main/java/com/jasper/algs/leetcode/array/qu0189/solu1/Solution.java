package com.jasper.algs.leetcode.array.qu0189.solu1;

/**
 * 0189. 旋转数组
 * 
 * <p> 暴力
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length, temp, previous;
        for (int i = 0; i < k; i++) {
			previous = nums[n - 1];
            for (int j = 0; j < n; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}