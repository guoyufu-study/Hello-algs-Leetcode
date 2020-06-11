package com.jasper.algs.contest.weekly.c192.qu5431.solu;

/**
 * 1473. 给房子涂色 III
 * 
 * <p> 2刷
 */
class Solution {
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
		
		return 0;
	}

	public static void main(String[] args) {
		// 9
//    	int[] houses = new int[] {0,0,0,0,0};
//    	int[][] cost = new int[][] {{1,10},{10,1},{10,1},{1,10},{5,1}}; 
//    	int m = 5; 
//    	int n = 2;
//    	int target = 3;

		// 5
//    	int[] houses = new int[] {0,0,0,0,0};
//    	int[][] cost = new int[][] {{1,10},{10,1},{1,10},{10,1},{1,10}};
//    	int m = 5;
//    	int n = 2;
//    	int target = 5;

		// 11
		int[] houses = new int[] { 0, 2, 1, 2, 0 };
		int[][] cost = new int[][] { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } };
		int m = 5;
		int n = 2;
		int target = 3;

		System.out.println(new Solution().minCost(houses, cost, m, n, target));
	}
}