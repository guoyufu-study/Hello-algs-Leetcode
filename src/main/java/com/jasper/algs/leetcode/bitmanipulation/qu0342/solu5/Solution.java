package com.jasper.algs.leetcode.bitmanipulation.qu0342.solu5;

/**
 * 5. 位运算 + 数学
 */
class Solution {
	public boolean isPowerOfFour(int num) {
	    return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
	  }
}