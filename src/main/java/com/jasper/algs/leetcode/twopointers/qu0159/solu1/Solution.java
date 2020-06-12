package com.jasper.algs.leetcode.twopointers.qu0159.solu1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 0159. 至多包含两个不同字符的最长子串
 * 
 * <p>
 * 滑动窗口+辅助字典
 */
class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		// 边界
		if (s == null || s.length() == 0)
			return 0;

		int n = s.length();

		// 滑动窗口 + 辅助字典
		int ans = 0;
		int left = 0, right = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (right < n) {

			map.put(s.charAt(right), right);

			// 扩展窗口
			right++;

			// 收缩窗口
			if (map.size() == 3) {
				// 更新答案
				ans = Math.max(ans, right - left);
				
				int del = Collections.min(map.values());
				map.remove(s.charAt(del));
				left = del + 1;
			}

		}

		return Math.max(ans, right - left);
	}
}