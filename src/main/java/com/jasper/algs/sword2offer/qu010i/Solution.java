package com.jasper.algs.sword2offer.qu010i;

/**
 * 求斐波那契数的第n项
 */
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}