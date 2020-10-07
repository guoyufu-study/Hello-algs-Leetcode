package com.jasper.algs.leetcode.sorting.qu0075.solu2;

/**
 * 0075. 颜色分类
 * 
 * <p>快慢指针：一次遍历
 */
class Solution {
    public void sortColors(int[] nums) {
    	// 快慢指针
        int n = nums.length;
        int slow0 = 0, fast = 0, slow2 = n-1;
        while(fast<=slow2) {
        	// 排2
            while(fast<=slow2 && nums[fast]==2) { 
                nums[fast] = nums[slow2];
                nums[slow2--] = 2;
            }
            // 排 0
            if(nums[fast]==0) {
                nums[fast] = nums[slow0];
                nums[slow0++] = 0;
            }
            fast++;
        }
    }
}