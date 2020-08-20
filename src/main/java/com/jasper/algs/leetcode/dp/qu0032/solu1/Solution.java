package com.jasper.algs.leetcode.dp.qu0032.solu1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 0032. 最长有效括号
 * 
 * <p>
 * 暴力枚举
 */
public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (!stack.empty() && stack.peek() == '(') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.empty();
	}

	public int longestValidParentheses(String s) {
		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (isValid(s.substring(i, j))) {
					maxlen = Math.max(maxlen, j - i);
				}
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		// 2
		String[] ss = new String[] { "(()", // 2
				")()())", // 4
		};

		List<Integer> ans = Arrays.stream(ss).map(new Solution()::longestValidParentheses).collect(Collectors.toList());

		System.out.println(ans);
	}
}