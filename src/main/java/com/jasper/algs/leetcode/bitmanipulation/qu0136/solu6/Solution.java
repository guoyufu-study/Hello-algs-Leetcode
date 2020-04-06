package com.jasper.algs.leetcode.bitmanipulation.qu0136.solu6;

/**
 * 双层循环
 */
public class Solution {

	public int singleNumber(int[] nums) {
        boolean found = false;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0 ; j < nums.length; j ++) {
                if (i!=j && nums[i] == nums[j]) { // 跳出内层for
                    found = true;
                    break;
                }
            }
            
            if (!found)  return nums[i]; // 未找到重复数字,直接返回
            found = false;
        }
        return -1;
    }
}
