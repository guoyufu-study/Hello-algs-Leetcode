package com.jasper.algs.leetcode.bitmanipulation.qu0231;

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