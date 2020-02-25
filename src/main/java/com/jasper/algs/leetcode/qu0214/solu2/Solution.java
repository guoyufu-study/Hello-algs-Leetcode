package com.jasper.algs.leetcode.qu0214.solu2;

/**
 * 双指针+递归 
 * <p>从字符串开头找到最大的回文子串，然后反转剩余的子串并附加到开头。
 */
public class Solution {

	public String shortestPalindrome(String s) {
		if(s==null || s.length()<1) return "";
		int i=0;
		for (int j = 0; j < s.length(); j++) {
			if(s.charAt(i)==s.charAt(s.length()-j-1)) i++;
		}
		if(i==s.length()) return s;
		return new StringBuilder(s.substring(i))
				.reverse()//尾部非回文部分反转
				.append(shortestPalindrome(s.substring(0,i)))//包含最长回文
				.append(s.substring(i))//尾部非回文部分
				.toString();
    }
	
}
