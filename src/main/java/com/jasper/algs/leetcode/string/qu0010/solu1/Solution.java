package com.jasper.algs.leetcode.string.qu0010.solu1;

/**
 * 0010. 正则表达式匹配
 * 
 * <p> 回溯
 */
class Solution {
	
	private String s;
	private String p;
	
    public boolean isMatch(String s, String p) {
    	
    	// 边界
//    	if(s.isEmpty() || p.isEmpty()) return s.isEmpty() && p.isEmpty(); // 错误：s=""，p="a*"
    	if(p.isEmpty()) return s.isEmpty();
    	
    	this.s = s;
    	this.p = p;
    	
    	return isMatch(0, 0);
    	
    }

	private boolean isMatch(int i, int j) {
		// 终止：模式串结束
    	if(j==p.length()) 
    		return i==s.length();
    	
    	// 首字母和.
    	boolean firstMatch = i<s.length() // 避免出现 s=""， p="a*"时数组越界问题
    			&& (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
    	
    	// 匹配 * 
    	if(j+1<p.length() && p.charAt(j+1)=='*') {
    		return isMatch(i, j+2) || // 匹配0次
    				(firstMatch && isMatch(i+1, j));// 匹配1次
    	}
    	
    	// 匹配字母和.
    	return firstMatch && isMatch(i+1, j+1);
	}
}