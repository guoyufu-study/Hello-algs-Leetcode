package com.jasper.algs.leetcode.bitmanipulation.qu0136.solu4;

/**
 * 位运算: 位掩码-异或
 */
public class Solution {

	public int singleNumber(int[] nums) {
		int seenOnce=0;
		for (int num : nums) seenOnce  ^= num; //位掩码-异或
		
		return seenOnce;
    }
}
