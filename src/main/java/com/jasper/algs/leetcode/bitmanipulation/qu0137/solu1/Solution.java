package com.jasper.algs.leetcode.bitmanipulation.qu0137.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 0137. 只出现过一次的数字 II
 * 
 * <p>辅助字典 + 求和相减
 */
public class Solution {

	public int singleNumber(int[] nums) {
		Set<Long> set = new HashSet<>();

		long sumSet = 0, sumArray = 0;
		for (int num : nums) {// sums 求和
			sumArray += num;
			set.add((long) num);
		}

		for (Long num : set)
			sumSet += num;// set 求和

		return (int) ((3 * sumSet - sumArray) / 2);
	}

}
