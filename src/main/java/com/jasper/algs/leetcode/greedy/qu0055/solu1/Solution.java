package com.jasper.algs.leetcode.greedy.qu0055.solu1;

/**
 * 0055. 跳跃游戏
 *
 * <p>贪心算法
 */
class Solution {
    public boolean canJump(int[] nums) {
    	
    	int target = nums.length-1;
    	int rightmost = 0;// 能够到达的最远位置
    	int index = 0;// 要处理的位置
    	
    	// 遍历能够到达的所有位置
    	while(index<=rightmost) {
    		// 更新最远位置
    		rightmost = Math.max(rightmost, index+nums[index]);
    		
    		if(rightmost>=target) return true;
    		
    		index++;
    	}
    	
    	return false;
    }
}