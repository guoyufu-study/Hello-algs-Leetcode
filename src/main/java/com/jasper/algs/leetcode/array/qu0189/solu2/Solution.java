package com.jasper.algs.leetcode.array.qu0189.solu2;

/**
 * 0189. 旋转数组
 * 
 * <p> 辅助数组
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
		int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = a[i];
        }
    }
}
