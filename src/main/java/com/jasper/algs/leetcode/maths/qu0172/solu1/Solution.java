package com.jasper.algs.leetcode.maths.qu0172.solu1;

/**
 * 0172. 阶乘后的零
 * 
 * <p> 数学
 */
class Solution {
    public int trailingZeroes(int n) {
    	int ans = 0;
    	while(n > 0) {
    		n /= 5;
    		ans += n;
    	}
    	return ans;
    }
}