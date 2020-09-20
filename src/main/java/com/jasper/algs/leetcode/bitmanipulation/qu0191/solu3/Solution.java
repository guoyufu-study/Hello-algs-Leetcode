package com.jasper.algs.leetcode.bitmanipulation.qu0191.solu3;

/**
 * 0191.位1的个数
 * 
 * <p>布赖恩·克尼根算法
 */
public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int bits = 0;
		while(n!=0) {
			bits++;
			n &= (n-1);
		}
		return bits;
	}
}
