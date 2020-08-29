package com.jasper.algs.leetcode.string.qu0344.solu2;

/**
 * 0344. 反转字符串
 * 
 * <p>
 * 双指针
 */
class Solution {
	public void reverseString(char[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			char tmp = s[left];
			s[left++] = s[right];
			s[right--] = tmp;
		}
	}
}