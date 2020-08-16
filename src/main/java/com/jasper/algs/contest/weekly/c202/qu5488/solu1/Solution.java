package com.jasper.algs.contest.weekly.c202.qu5488.solu1;

/**
 * 5488. 使数组中所有元素相等的最小操作数
 *
 * <p>数学运算
 */
class Solution {
    public int minOperations(int n) {
//    	int ans = 0;
//        if(n%2==1) {
//        	for(int i=2; i<n; i+=2) {
//        		ans += i;
//        	}
//        } else {
//        	for(int i=1; i<n; i+=2) {
//        		ans += i;
//        	}
//        }
//    	
//    	return ans;
    	
    	return n*n/4;
    }
}