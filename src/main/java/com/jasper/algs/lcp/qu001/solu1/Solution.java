package com.jasper.algs.lcp.qu001.solu1;

/**
 * LCP 01. 猜数字
 * 
 * <p> 比较计数
 */
class Solution {
    public int game(int[] guess, int[] answer) {
    	int ans = 0;
    	for (int i = 0; i < 3; i++) {
			if(guess[i]==answer[i]) ans++;
		}
    	return ans;
    }
}