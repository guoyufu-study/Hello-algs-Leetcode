package com.jasper.algs.leetcode.bitmanipulation.qu0136.solu7;

/**
 * 0136.只出现过一次的数字
 * 
 * <p> 位运算: 卡诺图生成状态转移公式
 */
public class Solution {

	public int singleNumber(int[] nums) {
		int ans=0;
		for (int num : nums) 
			ans  = (~ans & num) + (ans & ~num); //状态转移公式
		return ans;
    }
}
