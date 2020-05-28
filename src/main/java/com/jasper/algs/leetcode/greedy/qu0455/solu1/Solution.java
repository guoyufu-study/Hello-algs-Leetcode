package com.jasper.algs.leetcode.greedy.qu0455.solu1;

import java.util.Arrays;

/**
 * 0455. 分发饼干
 * 
 * <p>
 * 贪心算法
 */
class Solution {
	public int findContentChildren(int[] g, int[] s) {

		Arrays.sort(g);
		Arrays.sort(s);

		int m = g.length;
		int n = s.length;

		int ans = 0;
		int j = 0;
		for (int i = 0; i < m; i++) {
			// 饼干小了
			while (j < n && g[i] > s[j])
				j++;
			// 无饼干
			if (j == n)
				break;
			// 分到饼干
			ans++;
			j++;
		}

		return ans;
	}

	public static void main(String[] args) {
		// 1
//    	int[] g = new int[] {1,2,3};
//    	int[] s = new int[] {1,1};

		// 2
		int[] g = new int[] { 1, 2 };
		int[] s = new int[] { 1, 2, 3 };

		System.out.println(new Solution().findContentChildren(g, s));
	}
}