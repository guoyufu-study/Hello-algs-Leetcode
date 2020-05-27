package com.jasper.algs.leetcode.greedy.qu0392.solu2;

/**
 * 0392. 判断子序列
 * 
 * <p>
 * 二维辅助数组
 */
class Solution {
	public boolean isSubsequence(String s, String t) {
		// 预处理
		t = " " + t; // 开头加一个空字符作为匹配入口
		int n = t.length();
		// 记录每个位置的下一个ch的位置
		int[][] dp = new int[n][26];
		for (char ch = 0; ch < 26; ch++) {
			int p = -1;
			for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
				dp[i][ch] = p;
				if (t.charAt(i) == ch + 'a')
					p = i;
			}
		}

		// 匹配
		int i=0;
		for (char c : s.toCharArray()) {// 跳跃遍历
			if((i = dp[i][c-'a'])==-1)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// false
//		String s = "aaaaaa";
//		String t = "bbaaaa";

		// true
//		String s = "abc";
//		String t = "ahbgdc";

		// true
		String s = "abcd";
		String t = "abcd";

		System.out.println(new Solution().isSubsequence(s, t));
	}
}