package com.jasper.algs.contest.weekly.c103.qu0908.solu1;

/**
 * 0908. 最小差值 I
 * 
 * <p> 数学
 */
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = 0, min = 10_000;
        for(int a : A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        return Math.max(0, max - min - 2*K);
    }
}