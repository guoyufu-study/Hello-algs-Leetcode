package com.jasper.algs.leetcode.maths.qu0628.solu2;

/**
 * 0628. 三个数的最大乘积
 * 
 * <p> 线性扫描，找出最大的三个数，最小的两个数
 */
class Solution {
    public int maximumProduct(int[] nums) {
    	
    	int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE; // 最小、次小
    	int max1= Integer.MIN_VALUE, max2= Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;// 最大、次大、最三大
    			
    	for (int num : nums) {
			if(num<=min1) {
				min2 = min1;
				min1 = num;
			} else if(num<=min2) {
				min2 = num;
			}
			
			if(num>=max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if(num>=max2) {
				max3 = max2;
				max2 = num;
			}else if(num>=max3) {
				max3 = num;
			}
		}
    	
    	return Math.max(min1 * min2 * max1, 
    				max1 * max2 * max3);
    }
}