package com.jasper.algs.leetcode.twopointers.qu1437.solu2;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * 
 * <p> 计数
 */
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
    	
    	int count = k;
    	int N = nums.length;
		for (int i = 0; i < N; i++) {
			// 遇0计数
			if(nums[i]==0) count++;
			
			// 遇1判断
			else {
				if(count<k) return false;
				count=0;
			}
		}
    	
    	return true;
    }
}