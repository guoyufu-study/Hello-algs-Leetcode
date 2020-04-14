package com.jasper.algs.leetcode.bitmanipulation.qu0371;

class Solution {
    public int getSum(int a, int b) {
    	int ans = 0;
    	
    	do {
    		ans = a ^ b; // 两数相加，不考虑进位
    		b = (a & b); // 两数相加，只考虑进位

    		if(b != 0) { // 存在进位，继续
    			a = ans;
        		b = b<<1;
    		}
    		
    	} while(b != 0);
    	
		return ans;
    }
    
}