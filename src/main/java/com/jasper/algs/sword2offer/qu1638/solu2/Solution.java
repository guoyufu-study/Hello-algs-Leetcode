package com.jasper.algs.sword2offer.qu1638.solu2;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 *
 * <p>二分查找
 */
class Solution {
    public int missingNumber(int[] nums) {
    	
    	int N = nums.length;
    	
    	// 边界
    	if(nums[N-1]==N-1) return N;
    	
    	//左右指针
    	int left=0, right=N-1;
    	
    	while(left<right) {
    		
    		//计算中值：避免溢出，此处没必要
    		int m = (right-left)/2 + left;
    		
    		// 更新指针，缩小范围
    		if(m==nums[m])
    			left = m+1;
    		 else
    			right = m;
    	}
    	
    	return left;
    }
}