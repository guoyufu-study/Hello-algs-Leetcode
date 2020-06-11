package com.jasper.algs.sword2offer.qu1660.solu3;

/**
 * 1660. 面试题62. 圆圈中最后剩下的数字
 * 
 * <p> 动态规划：迭代实现
 */
class Solution {
    public int lastRemaining(int n, int m) {
    	
    	int ans = 0;
    	for(int i=2; i<=n; i++) {
    		ans = (m + ans)%i;
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 3
//    	int n = 5, m = 3;
    	
    	// 2
//    	int n = 10, m = 17;
    	
    	// 64165
    	int n = 70866, m = 116922;
    	
    	System.out.println(new Solution().lastRemaining(n, m));
	}
}