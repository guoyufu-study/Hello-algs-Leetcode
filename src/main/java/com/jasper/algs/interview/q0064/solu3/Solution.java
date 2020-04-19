package com.jasper.algs.interview.q0064.solu3;

/**
 * 使用位运算和加法，实现乘法
 */
class Solution {
    public int sumNums(int n) {
    	return (
    			((n & -(n+1 >> 0 & 1)) << 0) +
    			((n & -(n+1 >> 1 & 1)) << 1) +
    			((n & -(n+1 >> 2 & 1)) << 2) +
    			((n & -(n+1 >> 3 & 1)) << 3) +
    			((n & -(n+1 >> 4 & 1)) << 4) +
    			((n & -(n+1 >> 5 & 1)) << 5) +
    			((n & -(n+1 >> 6 & 1)) << 6) +
    			((n & -(n+1 >> 7 & 1)) << 7) +
    			((n & -(n+1 >> 8 & 1)) << 8) +
    			((n & -(n+1 >> 9 & 1)) << 9) +
    			((n & -(n+1 >> 10 & 1)) << 10) +
    			((n & -(n+1 >> 11 & 1)) << 11) +
    			((n & -(n+1 >> 12 & 1)) << 12) +
    			((n & -(n+1 >> 13 & 1)) << 13)
    		) >> 1;
    			
    }
    
    public static void main(String[] args) {
		int n = 10000;
		System.out.println(new Solution().sumNums(n ));
		
	}
}