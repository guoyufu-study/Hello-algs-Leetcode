package com.jasper.algs.leetcode.stack.qu1021.solu2;

import java.util.Stack;

class Solution {

	public String removeOuterParentheses(String S) {
		// 结果
		StringBuilder ans = new StringBuilder();
		
		// 辅助栈
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			//闭括号：弹出开括号
			if(S.charAt(i)==')') {
				stack.pop();
				if(!stack.isEmpty()) ans.append(')');
				continue;
			}
			// 开括号：压入开括号
			if(!stack.isEmpty()) ans.append('(');
			stack.push('(');
		}
		
		return ans.toString();
    }
}
