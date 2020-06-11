package com.jasper.algs.leetcode.string.qu0038.solu1;

/**
 * 0038. 外观数列
 *
 * <p>
 * 计数读
 */
class Solution {
	public String countAndSay(int n) {

		StringBuilder ans = new StringBuilder();
		ans.append('1');
		StringBuilder tmp;
		for (int i = 2; i <= n; i++) {
			tmp = new StringBuilder();

			// 首字符
			int count = 0;
			char prev = ans.charAt(0);
			for (int j = 0; j < ans.length(); j++) {
				char num = ans.charAt(j);

				// 相同字符
				if (num == prev) {
					count++;
				}
				// 不同字符
				else {
					tmp.append(count);
					tmp.append(prev);
					count = 1;
					prev = num;
				}
			}

			// 最后一个字符
			tmp.append(count);
			tmp.append(prev);

			ans = tmp;
		}

		return ans.toString();
	}
}