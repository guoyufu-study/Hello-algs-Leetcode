package com.jasper.algs.leetcode.twopointers.qu0340.solu1;

/**
 * 0159. 至多包含两个不同字符的最长子串
 * 
 * <p>
 * 滑动窗口 + 辅助字典
 */
class Solution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {

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
			if (len <= k) {
				ans = Math.max(ans, right - left + 1);
			}

			// 收缩窗口
			while (len > k) {
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