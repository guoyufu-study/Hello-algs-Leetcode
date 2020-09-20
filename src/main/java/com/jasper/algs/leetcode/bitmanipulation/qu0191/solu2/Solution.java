package com.jasper.algs.leetcode.bitmanipulation.qu0191.solu2;

/**
 * 0191.位1的个数
 * 
 * <p>32次位掩码
 */
public class Solution {
    // you need to treat n as an unsigned value
	public int hammingWeight(int n) {
	    int bits = 0;
	    int mask = 1;
	    for (int i = 0; i < 32; i++) {
	        if ((n & mask) != 0) {
	            bits++;
	        }
	        mask <<= 1;
	    }
	    return bits;
	}
}
