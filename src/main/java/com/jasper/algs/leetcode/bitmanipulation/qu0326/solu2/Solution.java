package com.jasper.algs.leetcode.bitmanipulation.qu0326.solu2;

/**
 * 基准转换
 */
class Solution {
    public boolean isPowerOfThree(int n) {
            
          return Integer.toString(n, 3).matches("^10*$");
    }
}