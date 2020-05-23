package com.jasper.algs.leetcode.hashmap.qu1001.solu;

/**
 * 1001. 网格照明
 * 
 */
class Solution {
	
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    	
    	return new int[0];
    }

	
	public static void main(String[] args) {
//		5
//		[[0,0],[0,1],[0,4]]
//		[[0,0],[0,1],[0,2]]
		int N = 5;
		int[][] lamps = new int[][] {{0,0},{0,1},{0,4}};
		int[][] queries = new int[][] {{0,0},{0,1},{0,2}};
		
		new Solution().gridIllumination(N, lamps, queries);
	}
}