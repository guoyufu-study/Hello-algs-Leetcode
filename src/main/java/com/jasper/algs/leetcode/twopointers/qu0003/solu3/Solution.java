package com.jasper.algs.leetcode.twopointers.qu0003.solu3;

import java.util.HashMap;
import java.util.Map;

/**
 * 0003.最长无重复字符子串
 * 
 * <p>
 * 滑动窗口 + HashMap字典查重
 * <p>
 * 使用HashMap作为字典，左边界一次滑动到位。
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int ans = 0, // 答案
				left = 0, // 窗口左边界（含）
				right = 0;// 窗口右边界（不含）

		// 字典：记录读过的所有字符，及其最新索引位置
		Map<Character, Integer> map = new HashMap<>();
		while (right < s.length()) {
			// 读过
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(map.get(s.charAt(right)), left);// 收缩窗口：尝试更新左边界
			}

			++right;// 扩展窗口：更新右边界
			map.put(s.charAt(right), right);// 更新字典（或入字典）
			ans = Math.max(ans, right - left);// 更新最大长度
		}

		return ans;
	}
}
