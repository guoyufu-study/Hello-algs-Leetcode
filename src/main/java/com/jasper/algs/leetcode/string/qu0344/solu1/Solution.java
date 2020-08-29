package com.jasper.algs.leetcode.string.qu0344.solu1;

/**
 * 0344. 反转字符串
 * 
 * <p>
 * 递归
 */
class Solution {

	public void helper(char[] s, int left, int right) {
		if (left >= right)
			return;
		char tmp = s[left];
		s[left++] = s[right];
		s[right--] = tmp;
		helper(s, left, right);
	}

	public void reverseString(char[] s) {
		helper(s, 0, s.length - 1);
	}
}