package com.jasper.algs.leetcode.bitmanipulation.qu0461.solu1;

/**
 * 0461. 汉明距离
 *
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int bits = 0;
        while(n!=0) {
            bits++;
            n &= (n-1);
        }
        return bits;
    }
}