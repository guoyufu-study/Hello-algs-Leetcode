package com.jasper.algs.leetcode.maths.qu0509.solu5;

/**
 * 公式法
 */
class Solution {
    public int fib(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }
}