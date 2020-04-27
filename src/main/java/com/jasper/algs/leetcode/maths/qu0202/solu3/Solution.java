package com.jasper.algs.leetcode.maths.qu0202.solu3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 0202. 快乐数
 * 
 * <p>
 * 硬编码唯一循环
 */
class Solution {
	private static Set<Integer> cycleMembers = 
			new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

	public int getNext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}

	public boolean isHappy(int n) {
		while (n != 1 && !cycleMembers.contains(n)) {
			n = getNext(n);
		}
		return n == 1;
	}

	public static void main(String[] args) {
		int n = 2;

		System.out.println(new Solution().isHappy(n));
	}
}