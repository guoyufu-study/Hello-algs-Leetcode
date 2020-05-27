package com.jasper.algs.leetcode.greedy.qu1024.solu;

/**
 * 1024. 视频拼接
 * 
 * <p> 2刷
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {

    	return 0;
    }
    
    public static void main(String[] args) {
    	// 3
//    	int T = 10;
//    	int[][] clips = new int[][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
    	
    	// -1
//    	int T = 5;
//    	int[][] clips = new int[][] {{0,1},{0,2}};
    	
    	// 3
//    	int T = 9;
//    	int[][] clips = new int[][] {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
    	
    	// 2
//    	int T = 5;
//    	int[][] clips = new int[][] {{0,4},{2,8}};
    	
    	// 1  无效的左边界
    	int T = 5;
    	int[][] clips = new int[][] {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
    	
    	System.out.println(new Solution().videoStitching(clips, T));
	}
}