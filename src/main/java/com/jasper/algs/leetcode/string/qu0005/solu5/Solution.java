package com.jasper.algs.leetcode.string.qu0005.solu5;

/**
 * 0005. 最长回文子串
 * 
 * <p> Manacher 算法（马拉车算法）
 */
public class Solution {

	public String longestPalindrome(String s) {
		
		return s;
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
