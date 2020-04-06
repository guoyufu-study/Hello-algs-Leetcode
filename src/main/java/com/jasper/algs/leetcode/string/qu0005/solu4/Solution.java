package com.jasper.algs.leetcode.string.qu0005.solu4;

/**
 * 中心扩展法
 */
public class Solution {

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);// i为中心
	        int len2 = expandAroundCenter(s, i, i + 1);// i, i+1两字母之间为中心
	        int len = Math.max(len1, len2);// 更新起始索引
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
		}
		return s.substring(start, end+1);//左闭右开
	}
	
	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;//多余
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
}
