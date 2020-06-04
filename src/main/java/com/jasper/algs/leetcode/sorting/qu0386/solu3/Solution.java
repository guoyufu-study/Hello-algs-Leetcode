package com.jasper.algs.leetcode.sorting.qu0386.solu3;

import java.util.ArrayList;
import java.util.List;

/**
 * 0386. 字典序排数
 *
 * <p>
 * 11叉树前序遍历 ：递归
 */
class Solution {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>(n);
		
		// 11叉树前序遍历
		preOrder(1, 10, n, result);
		
		return result;
	}

	private void preOrder(int start, int end, int limit, List<Integer> result) {
		for (int i = start; i < end && i <= limit; i++) {
			result.add(i);
			preOrder(i * 10, i * 10 + 10, limit, result);
		}
	}

	public static void main(String[] args) {
		// [1,10,11,12,13,2,3,4,5,6,7,8,9]
		int n = 13;

		System.out.println(new Solution().lexicalOrder(n));

	}
}