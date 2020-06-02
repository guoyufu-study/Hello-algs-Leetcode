package com.jasper.algs.sword2offer.qu1654.solu3;

/**
 * 1654.面试题64. 求1+2+…+n
 * 
 * <p>使用位运算和加法模拟乘法
 */
class Solution {
    public int sumNums(int n) {
    	int A = n, B = n+1;
    	return (
    			((A & -(B >> 0 & 1)) << 0) +
    			((A & -(B >> 1 & 1)) << 1) +
    			((A & -(B >> 2 & 1)) << 2) +
    			((A & -(B >> 3 & 1)) << 3) +
    			((A & -(B >> 4 & 1)) << 4) +
    			((A & -(B >> 5 & 1)) << 5) +
    			((A & -(B >> 6 & 1)) << 6) +
    			((A & -(B >> 7 & 1)) << 7) +
    			((A & -(B >> 8 & 1)) << 8) +
    			((A & -(B >> 9 & 1)) << 9) +
    			((A & -(B >> 10 & 1)) << 10) +
    			((A & -(B >> 11 & 1)) << 11) +
    			((A & -(B >> 12 & 1)) << 12) +
    			((A & -(B >> 13 & 1)) << 13)
    		) >> 1;
    			
    }
    
    public static void main(String[] args) {
		int n = 10000;
		System.out.println(new Solution().sumNums(n ));
		
	}
}