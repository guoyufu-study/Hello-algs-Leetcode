package com.jasper.algs.leetcode.greedy.qu0055.solu1;

/**
 * 0055. 跳跃游戏
 *
 * <p> 动态规划
 */
class Solution {
    public boolean canJump(int[] nums) {
    	// 目标位置
    	int N = nums.length-1;
    	for (int i = 1; i <= N; i++) {
    		// 无法跳到位置 i
    		if(nums[i-1]<i) 
    			return false;
    		
    		// 更新更远位置
			nums[i] = Math.max(nums[i-1], i+nums[i]);
		}
    	
    	// 包括 N=0 
    	return true;
    }
    
    public static void main(String[] args) {
		// true
    	int[] nums = new int[] {0};
    	
    	// true
//    	int[] nums = new int[] {2,3,1,1,4};
    	
    	// false
//    	int[] nums = new int[] {3,2,1,0,4};
    	
    	System.out.println(new Solution().canJump(nums));
	}
}