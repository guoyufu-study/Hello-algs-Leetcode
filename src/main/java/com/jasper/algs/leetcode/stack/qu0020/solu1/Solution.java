package com.jasper.algs.leetcode.stack.qu0020.solu1;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

	// Hash 表
	private HashMap<Character, Character> mappings;

	// 初始化，目的是为了代码更易读
	public Solution() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}

	public boolean isValid(String s) {

		// 辅助栈
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// 闭括号：出栈
			if (this.mappings.containsKey(c)) {

				// 出栈，默认'#'
				char topElement = stack.empty() ? '#' : stack.pop();

				// 如果闭括号与出栈值不匹配，返回false
				if (topElement != this.mappings.get(c)) {
					return false;
				}
			} else {
				// 开括号：入栈
				stack.push(c);
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
