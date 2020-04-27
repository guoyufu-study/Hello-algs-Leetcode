package com.jasper.algs.leetcode.maths.qu0263.solu1;

/**
 * 0263. 丑数
 *
 * <p>
 * 循环整除
 */
class Solution {
    public boolean isUgly(int num) {
    	// 边界
    	if(num<1) return false;
    	
    	// 循环整除
    	while(num%2==0)
    		num /= 2;
    	while(num%3==0)
    		num /= 3;
    	while(num%5==0)
    		num /= 5;
    	
    	return num==1;
    }
}