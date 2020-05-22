package com.jasper.algs.leetcode.string.qu0010.solu2;

/**
 * 0010. 正则表达式匹配
 * 
 * <p> 动态规划：迭代求解
 */
class Solution {
    public boolean isMatch(String s, String p) {
    	
    	return isMatch(s, p, 0, 0, new Result[s.length()+1][p.length()+1]);
    }

    /**
     * 
     * @param s		匹配串
     * @param p		匹配模式串
     * @param i
     * @param j
     * @param helper
     * @return
     */
	private boolean isMatch(String s, String p, int i, int j, Result[][] helper) {
    	
    	// 查找
    	if(helper[i][j]!=null) 
    		return helper[i][j]==Result.TRUE;
    	
    	// 结束
    	if(j==p.length()) {
    		helper[i][j] = i==s.length() ? Result.TRUE : Result.FALSE;
    		return helper[i][j]==Result.TRUE;
    	}
    	
    	// 匹配字母和.
    	boolean firstMatch = i<s.length() // 避免出现 s=""， p="a*"时数组越界问题
    			&& (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
    	
    	// 匹配 * 
    	if(j+1<p.length() && p.charAt(j+1)=='*') {
    		helper[i][j] = isMatch(s, p, i, j+2, helper) || // 匹配0次
    				(firstMatch && isMatch(s, p, i+1, j, helper))  // 匹配1次
    				? Result.TRUE : Result.FALSE;
    	} 
    	// 匹配字母和.
    	else {
    		helper[i][j] = firstMatch && isMatch(s, p, i+1, j+1, helper) 
    				? Result.TRUE : Result.FALSE;
    	}
    	
    	return helper[i][j]==Result.TRUE;
	}
}

enum Result {
    TRUE, FALSE
}