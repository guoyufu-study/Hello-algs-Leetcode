package com.jasper.algs.leetcode.qu0214.solu2;

/**
 * 双指针+递归 
 * <p>每次递归都构建一个新字符串，费时费内存。
 */
public class Solution2 {

	public String shortestPalindrome(String s) {
		if(s==null || s.length()<1) return "";
		
		int i = findLongestPalindromeSubStringLength(s, s.length());
		
		return new StringBuilder(s.substring(i))
				.reverse()
				.append(s)
				.toString();
    }
	
	private int findLongestPalindromeSubStringLength(String s, int n) {
		int i=0;
		for (int j = 0; j < n; j++) {
			if(s.charAt(i)==s.charAt(n-j-1)) i++;
		}
		if(i==n) return n;
		return findLongestPalindromeSubStringLength(s, i);
	}
	
}
