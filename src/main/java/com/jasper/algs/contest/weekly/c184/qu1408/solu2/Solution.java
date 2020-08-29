package com.jasper.algs.contest.weekly.c184.qu1408.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力搜索
 */
class Solution {
	public List<String> stringMatching(String[] words) {

		List<String> ans = new ArrayList<String>();

		for (int i = 0; i < words.length; i++) { // 子串
			int[] prefixTable = longestCommonPrefixSuffix(words[i]);
			for (int j = 0; j < words.length; j++) { // 长串
				if (i != j && kmpSearch(words[j], words[i], prefixTable)) {
					ans.add(words[i]);
					words[i] = ""; // 避免再次使用
					break;
				}
			}
		}

		return ans;
	}

	// KMP 搜索
	private boolean kmpSearch(String text, String pattern, int[] prefixTable) {

		int m = text.length();
		int n = pattern.length();
		int i = 0, j = 0;
		while (i < m) {
			if (j == n - 1 && text.charAt(i) == pattern.charAt(j)) {
				return true;
			}
			if (text.charAt(i) == pattern.charAt(j)) {// 匹配
				i++;
				j++;
			} else {// 失配
				j = prefixTable[j]; // 更新 j
				if (j == -1) {
					i++;
					j++;
				}
			}

		}
		return false;
	}

	// 构造前缀表：最长公共前后缀
	private int[] longestCommonPrefixSuffix(String pattern) {
		int[] prefixTable = new int[pattern.length()];

		prefixTable[0] = 0;
		int len = 0;// 最长公共前后缀的长度
		int i = 1;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				prefixTable[i] = ++len;
				i++;
			} else {
				if (len > 0)
					len = prefixTable[len - 1];
				else {
					prefixTable[i] = len;
					i++;
				}
			}
		}

		// 统一后移一位
		for (int j = prefixTable.length - 1; j > 0; j--) {
			prefixTable[j] = prefixTable[j - 1];
		}
		prefixTable[0] = -1;
		return prefixTable;
	}

	public static void main(String[] args) {
		
		String[] words = new String[] {"mass","as","hero","superhero"};

		System.out.println(new Solution().stringMatching(words));
	}
}
