package com.jasper.algs.leetcode.string.qu0214.solu2;

/**
 * 双指针+递归 
 * 相对于String.charAt，直接用数组更快。
 */
public class Solution3 {

	public String shortestPalindrome(String s) {
		if(s==null || s.length()<1) return "";
		
		char[] cs = s.toCharArray();
		int i = findLongestPalindromeSubStringLength(cs, cs.length);
		
		return new StringBuilder(s.substring(i))
				.reverse()
				.append(s)
				.toString();
    }
	
	private int findLongestPalindromeSubStringLength(char[] cs, int n) {
		int i=0;
		for (int j = 0; j < n; j++) {
			if(cs[i]==cs[n-j-1]) i++;
		}
		if(i==n) return n;
		return findLongestPalindromeSubStringLength(cs, i);
	}
	
}
