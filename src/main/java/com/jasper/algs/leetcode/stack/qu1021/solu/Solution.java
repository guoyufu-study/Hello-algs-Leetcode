package com.jasper.algs.leetcode.stack.qu1021.solu;

/**
 * 1021. 删除最外层括号
 * 
 * <p> 2刷
 */
class Solution {
    public String removeOuterParentheses(String S) {

    	StringBuilder ans = new StringBuilder();
    	
    	return ans.toString();
    }
    
    public static void main(String[] args) {
    	// "()()()"
		String S = "(()())(())";
		
		// "()()()()(())"
//		String S = "(()())(())(()(()))";
		
		// ""
//		String S = "()()";
		
		System.out.println(new Solution().removeOuterParentheses(S));
	}
}