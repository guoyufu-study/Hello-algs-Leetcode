package com.jasper.algs.contest.weekly.c169.qu1306.solu;

/**
 * 1306. 跳跃游戏 III
 * 
 * <p>
 * 2刷
 */
class Solution {
	public boolean canReach(int[] arr, int start) {

		return false;
	}

	public static void main(String[] args) {
		// true
//		int[] arr = new int[] {4,2,3,0,3,1,2};
//		int start = 5;
		
		// true
//		int[] arr = new int[] {4,2,3,0,3,1,2};
//		int start = 0;
		
		// false
//		int[] arr = new int[] {3,0,2,1,2};
//		int start = 0;
		
		// true 
		int[] arr = new int[] {0,1}; // left>=0
		int start = 1; 

		System.out.println(new Solution().canReach(arr, start));
	}
}