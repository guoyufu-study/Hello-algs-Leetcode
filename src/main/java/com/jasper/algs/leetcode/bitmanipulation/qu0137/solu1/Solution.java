package com.jasper.algs.leetcode.bitmanipulation.qu0137.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 求和相减 + 辅助HashSet
 */
public class Solution {

	public int singleNumber(int[] nums) {
		Set<Long> set = new HashSet<>();

		long sumSet = 0, sumArray = 0;
		for (int n : nums) {// sums 求和
			sumArray += n;
			set.add((long) n);
		}

		for (Long s : set)
			sumSet += s;// set 求和

		return (int) ((3 * sumSet - sumArray) / 2);
	}

}
