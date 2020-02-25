package com.jasper.algs.leetcode.qu0260.solu2;

/**
 * 位运算：异或+掩码
 */
public class Solution {

	public int[] singleNumber(int[] nums) {
		int bitmask=0;
		for (int num : nums) bitmask ^= num;//异或x^y
		
		int diff = bitmask & (-bitmask);//找xy不同：位中最右边1
		
		int x=0;
		for (int num : nums)
			if((num & diff) != 0) x ^= num;//求x
		
		return new int[] {x, bitmask ^ x};//求y
		
	}

}
