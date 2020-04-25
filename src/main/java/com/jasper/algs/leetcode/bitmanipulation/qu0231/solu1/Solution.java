package com.jasper.algs.leetcode.bitmanipulation.qu0231.solu1;

/**
 * 不断右移直到得到1，并且在此过程中，最低位不能是1
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
    	if(n==0) return false;
    	
    	while(n!=1) {
    		if(n>>1<<1<n) return false;//最低位不是0
    		n = n>>1;
    	}
    	
    	return true;
    }
}