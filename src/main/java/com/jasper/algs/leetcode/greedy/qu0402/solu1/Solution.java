package com.jasper.algs.leetcode.greedy.qu0402.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0402. 移掉K位数字
 * 
 * <p>
 * 贪心+辅助栈
 */
class Solution {
	public String removeKdigits(String num, int k) {

		Deque<Character> stack = new LinkedList<Character>();
		for (char digit : num.toCharArray()) {
			while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
				stack.removeLast();
				k -= 1;
			}
			stack.addLast(digit);
		}

		/* 删足 k 位 */
		for (int i = 0; i < k; ++i)
			stack.removeLast();

		// 构建答案
		StringBuilder ans = new StringBuilder();
		boolean leadingZero = true;
		for (char digit : stack) {
			if (leadingZero && digit == '0')
				continue; // 移除前导0
			leadingZero = false;
			ans.append(digit);
		}

		return ans.length() == 0 ? "0" : ans.toString();
	}
}