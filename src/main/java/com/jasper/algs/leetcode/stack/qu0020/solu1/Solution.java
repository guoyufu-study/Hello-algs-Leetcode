package com.jasper.algs.leetcode.stack.qu0020.solu1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 0020. 有效的括号
 * 
 * <p> 辅助栈
 */
class Solution {

	// Hash 表
	private static Map<Character, Character> mappings = new HashMap<>();
	// 初始化，目的是为了代码更易读
	static {
		mappings.put(')', '(');
		mappings.put(']', '[');
		mappings.put('}', '{');
	}
	
	public boolean isValid(String s) {

		// 辅助栈
		Stack<Character> stack = new Stack<Character>();
		
		for (char c : s.toCharArray()) {
			switch (c) {
			// 开括号：入栈
			case '(':
			case '[':
			case '{':
				stack.push(c);
				break;

			// 闭括号：出栈
			default:
				// 出栈，默认'#'
				char topElement = stack.empty() ? '#' : stack.pop();
				// 如果闭括号与出栈值不匹配，返回false
				if(topElement != mappings.get(c)) 
					return false;
				break;
			}
		}
		
		// 栈中有值，返回false；无值，返回true
		return stack.isEmpty();
	}
	
	
	public static void main(String[] args) {
//		System.out.println();
		int sum=0;
		int len = 65535;
		
		for (int i = 0; i < len+1; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}
