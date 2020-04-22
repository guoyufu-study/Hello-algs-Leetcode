package com.jasper.algs.interview.q1002;

/**
 * 青蛙跳台阶问题
 */
class Solution {
    public int numWays(int n) {
    	// 0 阶台阶有1种跳法；
    	// 1阶台阶有1种跳法；
    	if(n<=1) return 1;
    	
    	// 第n阶台阶，跳法分两类:
    	// F(n-1)种跳法的基础上，再跳1级到第n阶台阶；
    	// F(n-2)种跳法的基础上，不经过第n-1阶，再跳2级到第n阶台阶。如果跳1阶，再跳1阶到第n阶台阶，属于F(n-1)一类
    	int f1 = 1, // n-2层台阶跳法，初始第0阶
    		f2 = 1, // n-1层台阶跳法，初始第1阶
    		f = 0; // n层台阶跳法
        for(int i = 2; i <= n; i++){
            f = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = f;
        }
        
        return f;
    }
}