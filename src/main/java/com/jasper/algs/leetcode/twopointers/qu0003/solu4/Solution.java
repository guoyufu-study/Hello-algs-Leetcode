package com.jasper.algs.leetcode.twopointers.qu0003.solu4;

/**
 * 0003.最长无重复字符子串
 * 
 * <p>
 * 滑动窗口+数组字典查重
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {

		// 参照ASCII码， 只有128个字符，如果扩展成unicode编码，则需要扩大数组
		// 以下数组是通过数组下标关联对应字符，存储的值是该字符上一次在字符串中出现的位置。
		// 主要思想还是通过建立一个滑动窗口，最后取滑动窗口的长度。
		int[] last = new int[128];

		// 初始赋值
		for (int i = 0; i < last.length; i++) {
			last[i] = -1;
		}

		int ans = 0;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			int index = s.charAt(right);
			left = Math.max(left, last[index] + 1);
			ans = Math.max(ans, right - left + 1);
			last[index] = right;

		}
		return ans;
	}

	public static void main(String[] args) {
		// 3
		String s = "pwwkew";

		// 1
//		String s = "bbbbb";

		// 3
//		String s = "abcabcbb";

		System.out.println(new Solution().lengthOfLongestSubstring(s));
	}
}
