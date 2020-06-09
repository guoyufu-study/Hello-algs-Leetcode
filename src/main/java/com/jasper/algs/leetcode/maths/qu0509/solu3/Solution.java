package com.jasper.algs.leetcode.maths.qu0509.solu3;

/**
 * 0509.斐波那契数
 * 
 * <p>带记忆的自顶向下
 */
class Solution {
	
	// 辅助数组
    private Integer[] memo = new Integer[31];

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        memo[0] = 0;
        memo[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
      if (memo[N] != null) {
          return memo[N];
      }
      memo[N] = memoize(N-1) + memoize(N-2);
      return memoize(N);
    }
}