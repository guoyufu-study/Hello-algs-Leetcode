package com.jasper.algs.leetcode.twopointers.qu0076.solu2;

/**
 * 0076.最小覆盖子串
 * 
 * <p>
 * 滑动窗口+辅助数组
 */
class Solution {
	public String minWindow(String s, String t) {
		int n = s.length(), m = t.length();
		int[] map = new int[128];
		int size = 0;
		for (char c : t.toCharArray()) {
			if (map[c] == 0)
				size++;
			map[c]++;
		}

		int[] tmp = new int[128];
		int count = 0, len = Integer.MAX_VALUE, L = 0, R = -1;
		for (int left = 0, right = 0; left + m <= n && right < n; right++) {
			char c = s.charAt(right);
			if (map[c] == 0)
				continue;
			tmp[c]++;
			if (tmp[c] == map[c])
				count++;
			while (count == size) {
				c = s.charAt(left);
				++left;
				if (map[c] == 0)
					continue;
				if (tmp[c] == map[c]) {
					count--;
					if (len > right - left + 2) {
						L = left - 1;
						R = right + 1;
						len = R - L;
					}
				}
				tmp[c]--;
			}
		}

		return R == -1 ? "" : s.substring(L, R);
	}
}