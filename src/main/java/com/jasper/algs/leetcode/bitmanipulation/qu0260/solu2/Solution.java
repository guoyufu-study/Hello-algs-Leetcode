package com.jasper.algs.leetcode.bitmanipulation.qu0260.solu2;

/**
 * 位运算：异或+掩码
 */
public class Solution {

	public int[] singleNumber(int[] nums) {
		int bitmask=0;
		
		//求x^y：异或，消除出现偶数次的数据，保留出现奇数次的数据
		for (int num : nums) bitmask ^= num;
		
		//找xy不同：保留位中最右边 1
		int diff = bitmask & (-bitmask);
		
		int x=0;
		for (int num : nums)
			if((num & diff) != 0) x ^= num;//求x：排除y进行异或，求出x
		
		return new int[] {x, bitmask ^ x};//求y
		
	}

}
