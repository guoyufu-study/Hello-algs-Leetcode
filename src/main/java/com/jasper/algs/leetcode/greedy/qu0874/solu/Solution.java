package com.jasper.algs.leetcode.greedy.qu0874.solu;

/**
 * 0874. 模拟行走机器人
 * 
 * <p> 2刷
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

    	return 0;
    }
    
    public static void main(String[] args) {
    	// 25
//		int[] commands = new int[] {4,-1,3};
//		int[][] obstacles = new int[][] {};
		
		// 65
		int[] commands = new int[] {4,-1,4,-2,4};
		int[][] obstacles = new int[][] {{2,4}};
		
		System.out.println(new Solution().robotSim(commands, obstacles));
	}
}