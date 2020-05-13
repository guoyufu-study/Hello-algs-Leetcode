package com.jasper.algs.leetcode.bitmanipulation.qu0231.solu3;

/**
 * 最低位只有一个1
 * 
 * <p>清理最右侧的位1
 *
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
    	
    	return n > 0 && (n & (n-1)) == 0;
    }
}