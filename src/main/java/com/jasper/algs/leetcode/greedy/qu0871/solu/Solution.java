package com.jasper.algs.leetcode.greedy.qu0871.solu;

/**
 * 0871. 最低加油次数
 * 
 * <p> 2刷
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

    	return 0;
    }
    
    public static void main(String[] args) {
    	// 0
//		int target = 1;
//		int startFuel = 1;
//		int[][] stations = new int[][] {};
		
		// -1
//		int target = 100;
//		int startFuel = 1;
//		int[][] stations = new int[][] {{10,100}};
		
		// 2
		int target = 100;
		int startFuel = 10;
		int[][] stations = new int[][] {{10,60},{20,30},{30,30},{60,40}};
		
		System.out.println(new Solution().minRefuelStops(target, startFuel, stations));
	}
}