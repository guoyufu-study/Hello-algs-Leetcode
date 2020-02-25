package com.jasper.algs.leetcode.qu0136.solu5;

/**
 * 位运算: 卡诺图生成状态转移公式
 */
public class Solution {

	public int singleNumber(int[] nums) {
		int ans=0;
		for (int num : nums) 
			ans  = (~ans & num) + (ans & ~num); //状态转移公式
		return ans;
    }
}
