package com.jasper.algs.leetcode.bitmanipulation.qu0191.solu1;

/**
 * 0191.位1的个数
 * 
 * <p> 内置函数
 */
public class Solution {
    // you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		
	    return Integer.bitCount(n);
	}
}
