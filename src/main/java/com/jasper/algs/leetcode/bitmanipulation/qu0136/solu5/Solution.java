package com.jasper.algs.leetcode.bitmanipulation.qu0136.solu5;

/**
 * 0136.只出现过一次的数字
 * 
 * <p> 位运算:遍历32位计数取模
 */
public class Solution {

	public int singleNumber(int[] nums) {
		int ans=0;
		for (int i = 0; i < 32; i++) {
			int tmp=0;
			for (int num : nums) tmp += (num>>i)&1;
			ans ^= (tmp%2)<<i;
		}
		
		return ans;
    }
}
