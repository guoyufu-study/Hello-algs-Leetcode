package com.jasper.algs.leetcode.codec.qu0171.solu1;

/**
 * 0171. Excel表列序号
 *
 * <p> 进制转换
 */
class Solution {
    public int titleToNumber(String s) {
    	int ans = 0;
    	for (char c : s.toCharArray()) {
			ans = (ans * 26) + (c - 'A' + 1);
		}
    	return ans;
    }
}