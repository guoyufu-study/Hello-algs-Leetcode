package com.jasper.algs.leetcode.bitmanipulation.qu0326.solu1;

/**
 * 循环取模整除
 */
class Solution {
	public boolean isPowerOfThree(int n) {
		if(n <= 0) return false;
		
		while(n % 3 == 0 ) {
			n /= 3;
		}
		
		return n == 1;
    }
}