package com.jasper.algs.leetcode.bitmanipulation.qu0342.solu4;

/**
 * 位运算
 */
class Solution {
	public boolean isPowerOfFour(int num) {
    	return num > 0 // 正整数
    			&& (num & (num-1)) == 0 // 只有一个位上有1
    			&& (num & 0x55555555) == num; // 有1的位，在正确位置上
    	
    }
}