package com.jasper.algs.leetcode.binarysearch.qu0069.solu1;

/**
 * 0069. x 的平方根
 * 
 * <p> 袖珍计算器
 */
class Solution {
    public int mySqrt(int x) {

    	if(x==0) return 0;
    	int ans = (int)Math.exp(0.5 * Math.log(x));
    	return (long)(ans+1)*(ans+1) > x ? ans : ans+1;
    }
}