package com.jasper.algs.leetcode.string.qu0005.solu;

/**
 * 0005. 最长回文子串
 * 
 * <p> 4刷
 */
public class Solution {

	public String longestPalindrome(String s) {
		if(s==null || s.length()<=1) 
			return s;
		
		int start = 0, maxLen = 1;
		
		
		return s.substring(start, start+maxLen);
	}
	

	public static void main(String[] args) {
		// bab
		String s = "babad";
		
		// bb
//		String s = "cbbd";
		
		// bb
//		String s = "bb";
		
		System.out.println(new Solution().longestPalindrome(s));
	}
}
