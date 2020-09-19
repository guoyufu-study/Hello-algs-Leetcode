package com.jasper.algs.lcp.qu017.solu1;

/**
 * LCP 17. 速算机器人
 * 
 * <p> 暴力模拟
 */
class Solution {
    public int calculate(String s) {
    	int x = 1, y = 0;
    	for (char c : s.toCharArray()) {
			if(c=='A') x = 2 * x + y;
			else y = 2 * y + x;
		}
    	return x + y;
    }
}