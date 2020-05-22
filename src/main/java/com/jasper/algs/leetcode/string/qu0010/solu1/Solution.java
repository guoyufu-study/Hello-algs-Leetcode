package com.jasper.algs.leetcode.string.qu0010.solu1;

/**
 * 0010. 正则表达式匹配
 * 
 * <p> 回溯
 */
class Solution {
    public boolean isMatch(String s, String p) {
    	
    	// 边界
//    	if(s.isEmpty() || p.isEmpty()) return s.isEmpty() && p.isEmpty(); // 错误：s=""，p="a*"
    	if(p.isEmpty()) return s.isEmpty();
    	
    	return isMatch(s, p, 0, 0);
    	
    }

    /**
     * 
     * @param s		匹配串
     * @param p		匹配模式串
     * @param i		
     * @param j
     * @return
     */
	private boolean isMatch(String s, String p, int i, int j) {
		// 边界
    	if(j==p.length()) return i==s.length();
    	
    	// 匹配字母和.
    	boolean firstMatch = i<s.length() // 避免出现 s=""， p="a*"时数组越界问题
    			&& (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
    	
    	// 匹配 * 
    	if(j+1<p.length() && p.charAt(j+1)=='*') {
    		return isMatch(s, p, i, j+2) || // 匹配0次
    				(firstMatch && isMatch(s, p, i+1, j));// 匹配1次
    	}
    	
    	return firstMatch && isMatch(s, p, i+1, j+1);
	}
}