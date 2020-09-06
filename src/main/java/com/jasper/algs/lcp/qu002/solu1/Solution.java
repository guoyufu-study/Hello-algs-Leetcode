package com.jasper.algs.lcp.qu002.solu1;

/**
 * LCP 02. 分式化简
 * 
 * <p> 逆序颠倒
 */
class Solution {
    public int[] fraction(int[] cont) {
    	int len = cont.length;
    	int n = 1, m = cont[len-1];
    	for (int i = len-2; i >= 0; i--) {
			n += cont[i] * m;
			// 交换
			n = m^n;
			m = m^n;
			n = m^n;
		}
    	return new int[] {m, n};
    }
}