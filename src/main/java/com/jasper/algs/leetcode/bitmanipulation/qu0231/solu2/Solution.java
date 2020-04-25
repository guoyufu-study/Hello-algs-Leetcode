package com.jasper.algs.leetcode.bitmanipulation.qu0231.solu2;

/**
 * 最低位只有一个1
 * 
 * <p>获取最右侧的1
 *
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
    	if(n > 0 && (n & -n) == n)
    		return true;
    	
    	return false;
    }
}