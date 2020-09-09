package com.jasper.algs.sword2offer.qu058ii.solu2;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 
 * <p> 遍历拼接
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
    	int len = s.length();
    	StringBuilder ans = new StringBuilder();
		for(int i=n; i< n+len; i++) {
    		ans.append(s.charAt(i%len));
    	}
    	
    	return ans.toString();
    }
}