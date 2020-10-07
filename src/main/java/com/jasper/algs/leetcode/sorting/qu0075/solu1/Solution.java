package com.jasper.algs.leetcode.sorting.qu0075.solu1;

/**
 * 0075. 颜色分类
 * 
 * <p>计数排序：两次遍历
 */
class Solution {
    public void sortColors(int[] nums) {
        
    	// 计数
        int[] counts = new int[3];
        for(int num : nums) 
            counts[num]++;
        
        // 填充
        int index = 0, num = 0;
        for(int count : counts) {
            while(count-->0) nums[index++] = num;
            num++;
        }
    }
}