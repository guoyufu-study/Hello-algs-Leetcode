package com.jasper.algs.leetcode.sorting.qu0075.solu1;

/**
 * 计数排序：两次遍历
 */
class Solution {
    public void sortColors(int[] nums) {
        
    	int N = nums.length;
    	
    	// 第一次遍历：计数
    	int count0=0, count1=0;
		for (int i = 0; i < N; i++) {
			if(nums[i] == 0)
				count0++;
			else if(nums[i] == 1)
				count1++;
		}
		
		// 第二次遍历：填充
		for (int i = 0; i < count0; i++) {
			nums[i] = 0;
		}
		
		int count = count0+count1;
		for (int i = count0; i < count; i++) {
			nums[i] = 1;
		}
		
		for (int i = count; i < N; i++) {
			nums[i] = 2;
		}
		
    }
}