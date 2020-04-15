package com.jasper.algs.leetcode.bitmanipulation.qu0268.solu4;

/**
 * 4. 位运算
 */
class Solution {
    public int missingNumber(int[] nums) {

    	int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor ^= nums[i];
		}
		
		// 清理重复出现的数字，保留奇数次出现的数
    	for (int i = 0; i <= nums.length; i++) {
			xor ^= i;
		}
    	
    	return xor;
    }
}