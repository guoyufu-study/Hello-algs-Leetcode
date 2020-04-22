package com.jasper.algs.leetcode.maths.qu1137.solu1;

/**
 * 泰波那契数
 * <p>
 * 定义法
 */
class Solution {
    public int tribonacci(int n) {

    	// 边界值
    	if(n<2) return n;
    	if(n==2) return 1;
    	
    	int t0 = 0, // 第0个泰波那契数
    		t1 = 1, // 第1个泰波那契数
    		t2 = 1, // 第2个泰波那契数
    		tn = 0; // 第n个泰波那契数
    	
    	for (int i = 3; i <= n; i++) {
			tn = t0 + t1 + t2;
			t0 = t1;
			t1 = t2;
			t2 = tn;
		}
    	
    	return tn;
    }
}