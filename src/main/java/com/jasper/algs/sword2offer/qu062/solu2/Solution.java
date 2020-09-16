package com.jasper.algs.sword2offer.qu062.solu2;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 
 * <p> 动态规划：递归实现
 */
class Solution {
    public int lastRemaining(int n, int m) {
    	// 终止
    	if(n==1)
    		return 0;
    	
    	return (m + lastRemaining(n-1, m)) % n;
    }
    
    public static void main(String[] args) {
    	// 3
//    	int n = 5, m = 3;
    	
    	// 2
//    	int n = 10, m = 17;
    	
    	// 12
    	int n = 100, m = 17;
    	
    	// 64165
//    	int n = 70866, m = 116922;
    	
    	System.out.println(new Solution().lastRemaining(n, m));
	}
}