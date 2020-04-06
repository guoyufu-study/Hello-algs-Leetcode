package com.jasper.algs.leetcode.string.qu0214.solu1;

/**
 * 暴力求法
 * 
 * <p>从字符串开头找到最大的回文子串，然后反转剩余的子串并附加到开头。
 */
public class Solution {

	public String shortestPalindrome(String s) {
		if(s==null || s.length()<1) return "";
		
		StringBuilder rev = new StringBuilder(s).reverse();//反转
		for (int i = 0; i < rev.length(); i++) {//遍历找出最大回文子串
			if(rev.substring(i).equals(s.substring(0, rev.length()-i))) {
				return rev.substring(0, i)+s;//反转剩余的子串并附加到开头
			}
		}
		
		return "";
    }
}
