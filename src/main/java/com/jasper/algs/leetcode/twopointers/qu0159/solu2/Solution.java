package com.jasper.algs.leetcode.twopointers.qu0159.solu2;

/**
 * 0159. 至多包含两个不同字符的最长子串
 * 
 * <p>
 * 滑动窗口+数组
 */
class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		char[] cs = s.toCharArray();
		int n = cs.length;

		int ans = 0;
		int[] count = new int[128];
		int left = 0, right = 0, len = 0;
		while (right < n) {
			count[cs[right]]++;
			if (count[cs[right]] == 1) {
				len++;
			}

			// 维护答案
			if (len <= 2) {
				ans = Math.max(ans, right - left + 1);
			}

			// 收缩窗口
			while (len > 2) {
				count[cs[left]]--;
				if (count[cs[left]] == 0) {
					len--;
				}
				left++;
			}

			// 扩展窗口
			right++;
		}
		return ans;
	}
}