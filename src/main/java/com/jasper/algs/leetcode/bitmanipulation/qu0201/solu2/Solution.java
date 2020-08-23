package com.jasper.algs.leetcode.bitmanipulation.qu0201.solu2;

/**
 * 0201. 数字范围按位与
 * 
 * <p> 布莱恩·柯林汉算法
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	while(m < n) {
    		n &= (n-1);
    	}
    	
    	return n;
    }
}