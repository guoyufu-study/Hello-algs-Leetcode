package com.jasper.algs.leetcode.bitmanipulation.qu0201.solu1;

/**
 * 0201. 数字范围按位与
 * 
 * <p> 逐位位移
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	int shift = 0;
    	while(m != n) {
    		m >>= 1;
    		n >>= 1;
    		shift++;
    	}
    	
    	return m <<= shift;
    }
}