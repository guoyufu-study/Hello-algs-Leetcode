package com.jasper.algs.leetcode.bitmanipulation.qu0231.solu3;

/**
 * 最低位只有一个1
 * 
 * <p>清理最右侧的位1
 *
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
    	
    	if(n > 0 && (n & (n-1)) ==0)
    		return true;
    	
    	return false;
    }
}