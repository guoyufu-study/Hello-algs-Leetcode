package com.jasper.algs.leetcode.dynamicprogramming.qu0032.solu3;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 0032. 最长有效括号
 * 
 * <p> 辅助栈
 */
class Solution {
    public int longestValidParentheses(String s) {

    	int ans = 0;
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(-1);
    	for (int i = 0; i < s.length(); i++) {
    		// 遇到开括号，索引入栈；
			if(s.charAt(i)=='(')
				stack.push(i);
			
			// 遇到闭括号，索引出栈
			else {
				stack.pop();
				
				// 如果栈顶无元素，将当前元素下标入栈
				if(stack.isEmpty()) {
					stack.push(i);
				}
				// 当前元素下标，减去栈顶元素值，得出当前有效括号字符串的长度
				ans = Math.max(ans, i-stack.peek());
			}
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 2
		String[] ss = new String[] {
				"(()", // 2
				")()())", // 4
		};
		
		List<Integer> ans = Arrays.stream(ss)
			.map(new Solution()::longestValidParentheses)
			.collect(Collectors.toList());
		
		System.out.println(ans);
	}
}