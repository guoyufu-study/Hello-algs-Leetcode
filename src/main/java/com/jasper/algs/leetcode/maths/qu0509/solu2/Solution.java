package com.jasper.algs.leetcode.maths.qu0509.solu2;

/**
 * 带记忆的自底向上
 */
class Solution {

    public int fib(int N) {
    	if(N==0) return 0;
    	if(N==1) return 1;
    	
    	// 辅助数组
    	int[] memo = new int[N+1];
    	memo[1] = 1;
    	for (int i = 2; i <= N; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
    	
		return memo[N];
    }
    
}