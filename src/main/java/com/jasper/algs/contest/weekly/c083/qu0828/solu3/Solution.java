package com.jasper.algs.contest.weekly.c083.qu0828.solu3;

import java.util.Arrays;

/**
 * 0828. 统计子串中的唯一字符
 * 
 * <p>
 * 字母分别计数：辅助数组 - 优化
 */
class Solution {
	public int uniqueLetterString(String s) {
		long sum = 0;
		int[] preIndexes = new int[26], indexes = new int[26];
		Arrays.fill(indexes, -1);
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int k = s.charAt(i) - 'A';
			int i0 = preIndexes[k], i1 = indexes[k];
			if (i1 >= 0) {
				sum += (i1 - i0) * (i - i1);
			}
			preIndexes[k] = i1;
			indexes[k] = i;
		}
		for (int k = 0; k < 26; k++) {
			int i0 = preIndexes[k], i1 = indexes[k];
			if (i1 >= 0) {
				sum += (i1 - i0) * (n - i1);
			}
		}
		return (int) (sum % 1000_000_007);
	}

	public static void main(String[] args) {
//		String s = "AA";

		// 92
		String s = "LEETCODE";

		// 8
//		String s = "ABA";

		// 10
//		String s = "ABC";

		System.out.println(new Solution().uniqueLetterString(s));
	}
}