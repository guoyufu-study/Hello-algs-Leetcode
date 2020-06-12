package com.jasper.algs.leetcode.string.qu0010.solu2;

/**
 * 0010. 正则表达式匹配
 * 
 * <p> 动态规划：递归求解
 */
class Solution {
	
	private String s;
	private String p;
	private Result[][] helper;
	
    public boolean isMatch(String s, String p) {
    	
    	this.s = s;
    	this.p = p;
    	helper = new Result[s.length()+1][p.length()+1];
    	
    	return isMatch(0, 0);
    }

    /**
     * 
     * @param i
     * @param j
     * @param helper
     * @return
     */
	private boolean isMatch(int i, int j) {
    	
    	// 使用缓存
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
    		helper[i][j] = isMatch(i, j+2) || // 匹配0次
    				(firstMatch && isMatch(i+1, j))  // 匹配1次
    				? Result.TRUE : Result.FALSE;
    	} 
    	// 匹配字母和.
    	else {
    		helper[i][j] = firstMatch && isMatch(i+1, j+1) 
    				? Result.TRUE : Result.FALSE;
    	}
    	
    	return helper[i][j]==Result.TRUE;
	}
}

enum Result {
    TRUE, FALSE
}