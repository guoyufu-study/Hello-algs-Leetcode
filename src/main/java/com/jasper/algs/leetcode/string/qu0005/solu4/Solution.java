package com.jasper.algs.leetcode.string.qu0005.solu4;

/**
 * 0005. 最长回文子串
 * 
 * <p>中心扩展法
 */
public class Solution {

	public String longestPalindrome(String s) {
		// 边界
		if (s == null || s.length() <= 1) 
			return s;
		
		// 中心扩展
		int begin = 0, maxLen = 1;
		for (int i = 0; i < s.length(); i++) { // 注意i必须从0开始，比如 s="bb" 
			// 中心扩展法，计算回文子串长度
			int len1 = expandAroundCenter(s, i-1, i+1);// i为中心
	        int len2 = expandAroundCenter(s, i, i + 1);// i, i+1两字母之间为中心
	        int len = Math.max(len1, len2);// 更新起始索引
	        
	        // 更新最长回文子串
	        if (len > maxLen) {
	        	begin = i - (len - 1) / 2;
	        	maxLen = len;
	        }
		}
		
		// 构造
		return s.substring(begin, begin+maxLen);//左闭右开
	}
	
	private int expandAroundCenter(String s, int left, int right) {
	    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	    	left--;
	    	right++;
	    }
	    return right - left - 1;
	}
	
	public static void main(String[] args) {
		// bab
//		String s = "babad";
		
		// bb
//		String s = "cbbd";
		
		// bb
		String s = "bb";
		
		System.out.println(new Solution().longestPalindrome(s));
	}
}
