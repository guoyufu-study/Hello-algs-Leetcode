package com.jasper.algs.leetcode.bitmanipulation.qu0326.solu5;

/**
 * 整除限制
 */
class Solution {
    public boolean isPowerOfThree(int n) {
    	return n > 0 && 1162261467 % n == 0;
    }
}