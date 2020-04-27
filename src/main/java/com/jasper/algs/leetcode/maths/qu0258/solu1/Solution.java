package com.jasper.algs.leetcode.maths.qu0258.solu1;

/**
 * 0258. 各位相加
 * 
 * <p> 暴力循环
 *
 */
class Solution {
    public int addDigits(int num) {
    	
    	// 暴力循环
    	while(num/10!=0) {
    		// 各位相加
    		int digitSum = 0;
    		while(num!=0) {
    			digitSum += num%10;
    			num /= 10;
    		}
    		num = digitSum;
    	}
    	
    	return num;
    }
}