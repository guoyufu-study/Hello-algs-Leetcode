package com.jasper.algs.leetcode.array.qu0169.solu3;

/**
 * 摩尔投票
 */
class Solution {
    public int majorityElement(int[] nums) {
    	
    	int candidate = nums[0], // 候选人
    			count = 1; // 计票
    	for (int i = 1; i < nums.length; i++) {
			if(count == 0) { // 先尝试更换候选人
				candidate = nums[i];
			}
			
			if(candidate != nums[i]) // 再抵消投票
				count--;
			else {// 投票
				count++;
			}
		}
    	
    	return candidate;
    }
}