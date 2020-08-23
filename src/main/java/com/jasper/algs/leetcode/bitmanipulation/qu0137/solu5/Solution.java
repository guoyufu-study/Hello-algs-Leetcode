package com.jasper.algs.leetcode.bitmanipulation.qu0137.solu5;

/**
 * 0137. 只出现过一次的数字 II
 * 
 * <p>3. 位运算
 * <p>
 * 二：卡诺图法生成状态转移公式
 */
public class Solution {

	public int singleNumber(int[] nums) {
		int a = 0, b = 0;
		for (int num : nums) {
			int tmp = a;
			a = (a & ~num) | (b & num);
			b = ~tmp & (b ^ num);
		}
		return b;
	}

}
