package com.jasper.algs.contest.biweekly.bc10.qu1216.solu1;

/**
 * 1216. 验证回文字符串 III
 * 
 * <p>
 * 暴力枚举
 */
class Solution {
	public boolean isValidPalindrome(String s, int k) {

		return isValidPalindrome(s, 0, s.length() - 1, k);
	}

	boolean isValidPalindrome(String s, int left, int right, int k) {
		if (k < 0)
			return false;
		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}

		return left >= right || // 回文串
				isValidPalindrome(s, left + 1, right, k - 1) // 删除左侧字符
				|| isValidPalindrome(s, left, right - 1, k - 1); // 删除右侧字符
//				|| isValidPalindrome(s, left + 1, right - 1, k - 2); // 删除两侧 <- 没必要
	}
}