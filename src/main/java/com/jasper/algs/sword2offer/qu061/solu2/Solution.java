package com.jasper.algs.sword2offer.qu061.solu2;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 
 * <p> 排序
 */
class Solution {
    public boolean isStraight(int[] nums) {
    	Arrays.sort(nums);
    	int jacker = 0;
    	for (int i = 0; i < 4; i++) {
			if(nums[i]==0) jacker++; // 计数 jacker, 数量不限于 2
			else if(nums[i+1] == nums[i]) return false;// 重复
		}
    	return nums[4] - nums[jacker] < 5;// 长度低于 5
    }
}