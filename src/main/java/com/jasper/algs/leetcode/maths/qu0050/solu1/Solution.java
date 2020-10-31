package com.jasper.algs.leetcode.maths.qu0050.solu1;

/**
 * 0050. Pow(x, n)
 * 
 * <p> 快速幂（分治）
 */
class Solution {
    public double myPow(double x, int n) {
    	if(n==Integer.MIN_VALUE) return 1.0/(pow(x, -(n+1))*x);
    	
    	return n>=0 ? pow(x, n) : 1.0/pow(x, -n);
    }

	private double pow(double x, int n) {
		if(x==0) return 0;
		double ans = 1.0;
		while(n>0) {
			if((n&1)==1) ans *= x;
			x *= x;
			n>>=1;
		}
		return ans;
	}
}