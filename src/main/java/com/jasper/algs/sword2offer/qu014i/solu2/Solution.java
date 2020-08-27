package com.jasper.algs.sword2offer.qu014i.solu2;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 
 * <p> 贪心算法
 */
class Solution {
    public int cuttingRope(int n) {
    	if(n<=3)
    		return n-1;
    	
        int a = n/3, b = n%3;
        if(b==0) return (int) Math.pow(3, a);
        if(b==1) return (int) (Math.pow(3, a-1) * 4);
        return (int) (Math.pow(3, a) * 2);
    }
}