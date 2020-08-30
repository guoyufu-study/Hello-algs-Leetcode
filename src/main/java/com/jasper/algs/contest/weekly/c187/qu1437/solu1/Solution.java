package com.jasper.algs.contest.weekly.c187.qu1437.solu1;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * 
 * <p> 滑动窗口
 */
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
    	
    	int left= -k-1, right=0;// 滑动窗口
    	int N = nums.length;
    	
    	for (int i = 0; i < N; i++) {
    		
    		// 遇1，计算并判断
			if(nums[i]==1) {
				if(right-left<=k) return false;
				left = right; // 收缩窗口
			}
			
			// 扩展窗口
			right++;
		}
    	
    	return true;
    }
}